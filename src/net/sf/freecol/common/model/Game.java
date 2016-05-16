/**
 *  Copyright (C) 2002-2016   The FreeCol Team
 *
 *  This file is part of FreeCol.
 *
 *  FreeCol is free software: you can redistribute it and/or modify
 *  it under the terms of the GNU General Public License as published by
 *  the Free Software Foundation, either version 2 of the License, or
 *  (at your option) any later version.
 *
 *  FreeCol is distributed in the hope that it will be useful,
 *  but WITHOUT ANY WARRANTY; without even the implied warranty of
 *  MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *  GNU General Public License for more details.
 *
 *  You should have received a copy of the GNU General Public License
 *  along with FreeCol.  If not, see <http://www.gnu.org/licenses/>.
 */

package net.sf.freecol.common.model;

import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map.Entry;
import java.util.NoSuchElementException;
import java.util.UUID;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;

import javax.xml.stream.XMLStreamException;

import net.sf.freecol.common.i18n.NameCache;
import net.sf.freecol.common.io.FreeColXMLReader;
import net.sf.freecol.common.io.FreeColXMLWriter;
import net.sf.freecol.common.model.NationOptions.NationState;
import net.sf.freecol.common.option.OptionGroup;
import net.sf.freecol.common.util.LogBuilder;
import static net.sf.freecol.common.util.CollectionUtils.*;
import static net.sf.freecol.common.util.StringUtils.*;
import net.sf.freecol.common.util.Utils;


/**
 * The main component of the game model.
 */
public class Game extends FreeColGameObject {

    private static final Logger logger = Logger.getLogger(Game.class.getName());

    /** State for the FCGO iterator, out here because it has to be static. */
    private static enum FcgoState {
        INVALID,
        VALID,
        CONSUMED,
    };

    /** Map of all classes with corresponding server classes. */
    private static final java.util.Map<Class<? extends FreeColObject>,
                                       Class<? extends FreeColObject>>
        serverClasses = new HashMap<>();
    static {
        serverClasses.put(net.sf.freecol.common.model.Building.class,
                          net.sf.freecol.server.model.ServerBuilding.class);
        serverClasses.put(net.sf.freecol.common.model.Colony.class,
                          net.sf.freecol.server.model.ServerColony.class);
        serverClasses.put(net.sf.freecol.common.model.ColonyTile.class,
                          net.sf.freecol.server.model.ServerColonyTile.class);
        serverClasses.put(net.sf.freecol.common.model.Europe.class,
                          net.sf.freecol.server.model.ServerEurope.class);
        serverClasses.put(net.sf.freecol.common.model.Game.class,
                          net.sf.freecol.server.model.ServerGame.class);
        serverClasses.put(net.sf.freecol.common.model.IndianSettlement.class,
                          net.sf.freecol.server.model.ServerIndianSettlement.class);
        serverClasses.put(net.sf.freecol.common.model.Region.class,
                          net.sf.freecol.server.model.ServerRegion.class);
        serverClasses.put(net.sf.freecol.common.model.Player.class,
                          net.sf.freecol.server.model.ServerPlayer.class);
        serverClasses.put(net.sf.freecol.common.model.Unit.class,
                          net.sf.freecol.server.model.ServerUnit.class);
    };

    /**
     * Map of class name to class for the location classes, to speed
     * up game loading.
     */
    private static final java.util.Map<String, Class<? extends FreeColGameObject>>
        locationClasses = new HashMap<>();
    static {
        locationClasses.put("Building",
                            net.sf.freecol.common.model.Building.class);
        locationClasses.put("Colony",
                            net.sf.freecol.common.model.Colony.class);
        locationClasses.put("ColonyTile",
                            net.sf.freecol.common.model.ColonyTile.class);
        locationClasses.put("Europe",
                            net.sf.freecol.common.model.Europe.class);
        locationClasses.put("HighSeas",
                            net.sf.freecol.common.model.HighSeas.class);
        locationClasses.put("IndianSettlement",
                            net.sf.freecol.common.model.IndianSettlement.class);
        locationClasses.put("Map",
                            net.sf.freecol.common.model.Map.class);
        locationClasses.put("Tile",
                            net.sf.freecol.common.model.Tile.class);
        locationClasses.put("Unit",
                            net.sf.freecol.common.model.Unit.class);
    };


    /**
     * The next available identifier that can be given to a new
     * <code>FreeColGameObject</code>.
     */
    protected int nextId = 1;

    /** Game UUID, persistent in savegame files */
    private UUID uuid = UUID.randomUUID();

    /** The client player name, null in the server. */
    private final String clientUserName;

    /** All the players in the game. */
    protected final List<Player> players = new ArrayList<>();

    /** A virtual player to use for enemy privateers. */
    private Player unknownEnemy;

    /** The map of the New World. */
    private Map map = null;

    /**
     * The current nation options.  Mainly used to see if a player
     * nation is available.
     */
    private NationOptions nationOptions = null;

    /** The player whose turn it is. */
    protected Player currentPlayer = null;

    /** The current turn. */
    private Turn turn = new Turn(1);

    /** Whether the War of Spanish Succession has already taken place. */
    private boolean spanishSuccession = false;

    /** Initial active unit identifier. */
    private String initialActiveUnitId = null;
    
    // Serialization not required below.

    /** The Specification this game uses. */
    private Specification specification = null;

    /**
     * References to all objects created in this game.
     * Serialization is not needed directly as these must be completely
     * within { players, unknownEnemy, map } which are directly serialized.
     */
    protected final HashMap<String, WeakReference<FreeColGameObject>> freeColGameObjects;

    /**
     * The combat model this game uses. At the moment, the only combat
     * model available is the SimpleCombatModel, which strives to
     * implement the combat model of the original game.  However, it is
     * anticipated that other, more complex combat models will be
     * implemented in future.  As soon as that happens, we will also
     * have to make the combat model selectable.
     */
    protected CombatModel combatModel = null;

    /** The number of removed FCGOs that should trigger a cache clean. */
    private static final int REMOVE_GC_THRESHOLD = 64;

    /** The number of FCGOs removed since last cache clean. */
    private int removeCount = 0;

    /**
     * A FreeColGameObjectListener to watch the objects in the game.
     * Usually this is the AIMain instance.
     * FIXME: is this better done with a property change listener?
     */
    protected FreeColGameObjectListener freeColGameObjectListener = null;


    /**
     * Trivial constructor for use in Game.newInstance.
     */
    public Game() {
        super((Game)null);

        this.clientUserName = null;
        this.players.clear();
        this.unknownEnemy = null;
        this.map = null;
        this.nationOptions = null;
        this.currentPlayer = null;
        this.spanishSuccession = false;
        this.initialActiveUnitId = null;
        this.specification = null;
        this.freeColGameObjects = new HashMap<>(10000);
        this.combatModel = new SimpleCombatModel();
        this.removeCount = 0;
        internId("0");
        this.initialized = true;
    }

    /**
     * Constructor used by the ServerGame constructor.
     *
     * @param specification The <code>Specification</code> for this game.
     */
    protected Game(Specification specification) {
        this();

        setSpecification(specification);
    }


    /**
     * Instantiate an uninitialized FreeColGameObject within this game.
     *
     * @param <T> The actual return type.
     * @param returnClass The required <code>FreeColObject</code> class.
     * @param server Create a server object if possible.
     * @return The new uninitialized object, or null on error.
     */
    public final <T extends FreeColObject> T newInstanceGameClass(Class<T> returnClass,
                                                   boolean server) {
        @SuppressWarnings("unchecked")
       final Class<T> rc = !server ? null : (Class<T>) serverClasses.get(returnClass);
        return FreeColGameObject.newInstance(this, rc != null ? rc : returnClass);
    }
    
    
    /**
     * Get the difficulty level of this game.
     *
     * @return An <code>OptionGroup</code> containing the difficulty settings.
     */
    public final OptionGroup getDifficultyOptionGroup() {
        return specification.getDifficultyOptionGroup();
    }

    /**
     * Gets the game options associated with this game.
     *
     * @return An <code>OptionGroup</code> containing the game options.
     */
    public OptionGroup getGameOptions() {
        return specification.getGameOptions();
    }

    /**
     * Sets the game options associated with this game.
     *
     * @param go An <code>OptionGroup</code> containing the game options.
     */
    public void setGameOptions(OptionGroup go) {
        specification.setGameOptions(go);
    }

    /**
     * Gets the map generator options associated with this game.
     *
     * @return An <code>OptionGroup</code> containing the map
     *     generator options.
     */
    public OptionGroup getMapGeneratorOptions() {
        return specification.getMapGeneratorOptions();
    }

    /**
     * Sets the map generator options associated with this game.
     *
     * @param mgo An <code>OptionGroup</code> containing the map
     *     generator options.
     */
    public void setMapGeneratorOptions(OptionGroup mgo) {
        specification.setMapGeneratorOptions(mgo);
    }

    /**
     * Stub for routine only meaningful in the server.
     *
     * @return Nothing.
     */
    public String getNextId() {
        throw new IllegalStateException("game.getNextId not implemented");
    }

    /**
     * Gets the <code>FreeColGameObject</code> with the given identifier.
     *
     * @param id The object identifier.
     * @return The game object, or null if not found.
     */
    public FreeColGameObject getFreeColGameObject(String id) {
        if (id == null || id.isEmpty()) return null;
        final WeakReference<FreeColGameObject> ro = freeColGameObjects.get(id);
        if (ro == null) return null;
        final FreeColGameObject $ = ro.get();
        if ($ != null)
			return $;
		removeFreeColGameObject(id, "missed");
		return null;
    }

    /**
     * Gets the <code>FreeColGameObject</code> with the specified
     * identifier and class.
     *
     * @param <T> The actual return type.
     * @param id The object identifier.
     * @param returnClass The expected class of the object.
     * @return The game object, or null if not found.
     */
    public <T extends FreeColGameObject> T getFreeColGameObject(String id,
        Class<T> returnClass) {
      final  FreeColGameObject fcgo = getFreeColGameObject(id);
        try {
            return returnClass.cast(fcgo);
        } catch (ClassCastException e) {
            return null;
        }
    }

    /**
     * Registers a new <code>FreeColGameObject</code> with a given
     * identifier.
     *
     * @param id The object identifier.
     * @param o The <code>FreeColGameObject</code> to add to this
     *     <code>Game</code>.
     * @exception IllegalArgumentException If either the identifier or
     *     object are null.
     */
    public void setFreeColGameObject(String id, FreeColGameObject o) {
		if (id == null || id.isEmpty())
			throw new IllegalArgumentException("Null/empty id.");
		if (o == null)
			throw new IllegalArgumentException("Null FreeColGameObject.");
		final FreeColGameObject old = getFreeColGameObject(id);
		if (old != null)
			throw new IllegalArgumentException("Tried to replace FCGO " + id + " : " + old.getClass() + " with "
					+ o.getId() + " : " + o.getClass());
		final WeakReference<FreeColGameObject> wr = new WeakReference<>(o);
		freeColGameObjects.put(id, wr);
		notifySetFreeColGameObject(id, o);
	}

    /**
     * Removes the <code>FreeColGameObject</code> with the specified
     * identifier.
     *
     * @param id The object identifier.
     * @param reason A reason to remove the object.
     * @exception IllegalArgumentException If the identifier is null or empty.
     */
    public void removeFreeColGameObject(String id, String reason) {
        if (id == null) throw new IllegalArgumentException("Null identifier.");
        if (id.isEmpty()) throw new IllegalArgumentException("Empty identifier.");

        logger.finest("removeFCGO/" + reason + ": " + id);
        freeColGameObjects.remove(id);
        notifyRemoveFreeColGameObject(id);

        if (++removeCount <= REMOVE_GC_THRESHOLD)
			return;
		for (Iterator<FreeColGameObject> iterator = getFreeColGameObjects().iterator(); iterator.hasNext();)
			removeCount = 0;
		System.gc();
    }

    /**
     * Convenience wrapper to find a location (which is an interface,
     * precluding using the typed version of getFreeColGameObject())
     * by identifier.
     *
     * Use this routine when the object should already be present in the game.
     *
     * @param id The object identifier.
     * @return The <code>Location</code> if any.
     */
    public Location findFreeColLocation(String id) {
        final FreeColGameObject fcgo = getFreeColGameObject(id);
        return !(fcgo instanceof Location) ? null : (Location) fcgo;
    }

    /**
     * Gets an <code>Iterator</code> over every registered
     * <code>FreeColGameObject</code>.
     *
     * This <code>Iterator</code> should be iterated once in a while
     * since it cleans the <code>FreeColGameObject</code> cache.  Very
     * few routines call this any more, so there is a thresholded call
     * in removeFreeColGameObject to ensure the cache is still
     * cleaned.  Reconsider this if the situation changes.
     *
     * @return An <code>Iterator</code> containing every registered
     *     <code>FreeColGameObject</code>.
     */
    public Iterator<FreeColGameObject> getFreeColGameObjectIterator() {
        return new Iterator<FreeColGameObject>() {

            /** An iterator over the freeColGameObjects map. */
            private final Iterator<Entry<String,
                                         WeakReference<FreeColGameObject>>> it
                = freeColGameObjects.entrySet().iterator();

            /** Read ahead to this next entry. */
            private Entry<String, WeakReference<FreeColGameObject>> readAhead
                = null;

            /** State of the readahead value. */
            private FcgoState fcgoState = FcgoState.INVALID;


            @Override
            public boolean hasNext() {
                if (this.fcgoState == FcgoState.VALID) return true;
                while (this.it.hasNext()) {
                    this.readAhead = this.it.next();
                    if (this.readAhead.getValue().get() != null) {
                        this.fcgoState = FcgoState.VALID;
                        return true;
                    }
                    this.fcgoState = FcgoState.CONSUMED;
                    remove();
                }
                return false;
            }

            @Override
            public FreeColGameObject next() {
                if (!hasNext()) throw new NoSuchElementException();
                FreeColGameObject $ = this.readAhead.getValue().get();
                this.fcgoState = FcgoState.CONSUMED;
                return $;
            }

            @Override
            public void remove() {
                if (this.fcgoState == FcgoState.INVALID)
					throw new IllegalStateException("No current entry");
                final String key = this.readAhead.getKey();
                this.fcgoState = FcgoState.INVALID;
                this.it.remove();
                logger.finest("removeFCGO/expire: " + key);
                notifyRemoveFreeColGameObject(key);
            }
        };
    }

    /**
     * Get an <code>Iterable</code> over the <code>FreeColGameObjects</code>.
     *
     * @return A suitable <code>Iterable</code>.
     */
    public Iterable<FreeColGameObject> getFreeColGameObjects() {
        return new Iterable<FreeColGameObject>() {
            @Override
            public Iterator<FreeColGameObject> iterator() {
                return getFreeColGameObjectIterator();
            }
        };
    }

    /**
     * Gets the unique identifier for this game. 
     * A game UUID persists in save game files.
     *
     * @return The game <code>UUID</code>.
     */
    public UUID getUUID () {
       return uuid;
    }

    /**
     * Get all the players in the game.
     *
     * @return The list of <code>Player</code>s.
     */
    public List<Player> getPlayers() {
        return players;
    }

    /**
     * Get a <code>Player</code> identified by its nation.
     *
     * @param n The <code>Nation</code> to search for.
     * @return The <code>Player</code> of the given nation, or null if
     *     not found.
     */
    public Player getPlayerByNation(Nation n) {
        return getPlayerByNationId(n.getId());
    }

    /**
     * Get a <code>Player</code> identified by its nation identifier.
     *
     * @param nationId The nation identifier to search for.
     * @return The <code>Player</code> of the given nation, or null if
     *     not found.
     */
    public Player getPlayerByNationId(String nationId) {
        return find(players, p -> p.getNationId().equals(nationId));
    }

    /**
     * Get live players in the game.
     *
     * @param other An optional <code>Player</code> to omit.
     * @return The list of live <code>Player</code>s.
     */
    public List<Player> getLivePlayers(Player other) {
        return transform(players,
            p -> !p.isUnknownEnemy() && !p.isDead() && p != other,
            Collectors.toList());
    }

    /**
     * Get live players in the game, optionally excluding supplied ones.
     *
     * @param ps The <code>Player</code>s to exclude.
     * @return A list of live <code>Player</code>s, with exclusions.
     */
    public List<Player> getOtherLivePlayers(Player... ps) {
        final List<Player> $ = getLivePlayers(null);
        for (Player other : ps) $.remove(other);
        return $;
    }

    /**
     * Get the live European players in this game.
     *
     * @param other An optional <code>Player</code> to omit.
     * @return A list of live European <code>Player</code>s in this game.
     */
    public List<Player> getLiveEuropeanPlayers(Player other) {
        return transform(players,
            p -> !p.isUnknownEnemy() && !p.isDead() && p != other && p.isEuropean(),
            Collectors.toList());
    }

    /**
     * Get the live native players in this game.
     *
     * @param other An optional <code>Player</code> to omit.
     * @return A list of live native <code>Player</code>s in this game.
     */
    public List<Player> getLiveNativePlayers(Player other) {
        return transform(players,
            p -> !p.isUnknownEnemy() && !p.isDead() && p != other && p.isIndian(),
            Collectors.toList());
    }

    /**
     * Gets the next current player.
     *
     * @return The <code>Player</code> whose turn follows the current player.
     */
    public Player getNextPlayer() {
        return getPlayerAfter(currentPlayer);
    }

    /**
     * Gets the live player after the given player.
     *
     * @param beforePlayer The <code>Player</code> before the
     *     <code>Player</code> to be returned.
     * @return The <code>Player</code> after the <code>beforePlayer</code>
     *     in the list which determines the order each player becomes the
     *     current player.
     * @see #getNextPlayer
     */
    public Player getPlayerAfter(Player beforePlayer) {
        if (players.isEmpty()) return null;

        final int start = players.indexOf(beforePlayer);
        int index = start;
        do {
            if (++index >= players.size()) index = 0;
            Player $ = players.get(index);
            if (!$.isUnknownEnemy() && !$.isDead()) return $;
        } while (index != start);
        return null;
    }

    /**
     * Get the first player in this game.
     *
     * @return The first player, or null if none present.
     */
    public Player getFirstPlayer() {
        return (players.isEmpty()) ? null : players.get(0);
    }

    /**
     * Gets a player specified by a name.
     *
     * @param name The name identifying the <code>Player</code>.
     * @return The <code>Player</code> or null if none found.
     */
    public Player getPlayerByName(String name) {
        return find(players, p -> p.getName().equals(name));
    }

    /**
     * Checks if the specified player name is in use.
     *
     * @param name The name to check.
     * @return True if the name is already in use.
     */
    public boolean playerNameInUse(String name) {
        return getPlayerByName(name) != null;
    }

    /**
     * Adds the specified player to the game.
     *
     * @param p The <code>Player</code> to add.
     * @return True if the player was added.
     */
    public boolean addPlayer(Player p) {
        if (p.isAI() || canAddNewPlayer()) {
            players.add(p);
            final Nation nation = getSpecification().getNation(p.getNationId());
            nationOptions.getNations().put(nation, NationState.NOT_AVAILABLE);
            if (currentPlayer == null) currentPlayer = p;
            return true;
        }
        logger.warning("Game already full, but tried to add: "
            + p.getName());
        return false;
    }

    /**
     * Removes the specified player from the game.
     *
     * @param p The <code>Player</code> to remove.
     * @return True if the player was removed.
     */
    public boolean removePlayer(Player p) {
        final Player newCurrent = (currentPlayer != p) ? null
            : getPlayerAfter(currentPlayer);

        if (!players.remove(p)) return false;

        final Nation nation = getSpecification().getNation(p.getNationId());
        nationOptions.getNations().put(nation, NationState.AVAILABLE);
        p.dispose();

        if (newCurrent != null) currentPlayer = newCurrent;
        return true;
    }

    /**
     * Gets the unknown enemy player, which is used for privateers.
     *
     * @return The unknown enemy <code>Player</code>.
     */
    public Player getUnknownEnemy() {
        return unknownEnemy;
    }

    /**
     * Sets the unknown enemy player.
     *
     * @param p The <code>Player</code> to serve as the unknown enemy.
     */
    public void setUnknownEnemy(Player p) {
        this.unknownEnemy = p;
    }

    /**
     * Get the client player this thread is operating for.  If in the server
     * there will be none.
     *
     * @return The client <code>Player</code>.
     */
    public Player getClientPlayer() {
        return (clientUserName == null) ? null
            : getPlayerByName(clientUserName);
    }

    /**
     * Are we executing in a client?
     *
     * @return True in a client.
     */
    public boolean isInClient() {
        return clientUserName != null;
    }

    /**
     * Are we executing in the server?
     *
     * @return True in the server.
     */
    public boolean isInServer() {
        return clientUserName == null;
    }

    /**
     * Is this game in revenge mode?
     *
     * @return True if an undead player is present.
     */
    public boolean isInRevengeMode() {
        return contains(getPlayers(), Player::isUndead);
    }

    /**
     * Gets the current player.
     *
     * @return The current player.
     */
    public Player getCurrentPlayer() {
        return this.currentPlayer;
    }

    /**
     * Sets the current player.
     *
     * @param newCurrentPlayer The new current <code>Player</code>.
     */
    public void setCurrentPlayer(Player newCurrentPlayer) {
        this.currentPlayer = newCurrentPlayer;
    }

    /**
     * Gets the map that is being used in this game.
     *
     * @return The game <code>Map</code>.
     */
    public Map getMap() {
        return map;
    }

    /**
     * Sets the game map.
     *
     * @param newMap The new <code>Map</code> to use.
     */
    public void setMap(Map newMap) {
        if (this.map != newMap)
			for (Player player : getLivePlayers(null))
				if (player.getHighSeas() != null) {
					player.getHighSeas().removeDestination(this.map);
					player.getHighSeas().addDestination(newMap);
				}
        this.map = newMap;
    }

    /**
     * Get the current nation options.
     *
     * @return The current <code>NationOptions</code>.
     */
    public final NationOptions getNationOptions() {
        return nationOptions;
    }

    /**
     * Set the current nation options.
     *
     * @param newNationOptions The new <code>NationOptions</code> value.
     */
    public final void setNationOptions(final NationOptions newNationOptions) {
        this.nationOptions = newNationOptions;
    }

    /**
     * Find an available (i.e. vacant) nation.
     *
     * @return A vacant <code>Nation</code> or null if none found.
     */
    public Nation getVacantNation() {
        Entry<Nation,NationState> entry
            = find(nationOptions.getNations().entrySet(),
                e -> e.getValue() == NationState.AVAILABLE, null);
        return (entry == null) ? null : entry.getKey();
    }

    /**
     * Get the currently available nations.
     *
     * @return A list of available <code>Nation</code>s.
     */
    public final List<Nation> getVacantNations() {
        return transform(nationOptions.getNations().entrySet(),
                         e -> e.getValue() == NationState.AVAILABLE,
                         Entry::getKey, Collectors.toList());
    }

    /**
     * Can a new player be added to this game?
     *
     * @return True if a new player can be added.
     */
    public boolean canAddNewPlayer() {
        return getVacantNation() != null;
    }

    /**
     * Gets the current turn in this game.
     *
     * @return The current <code>Turn</code>.
     */
    public Turn getTurn() {
        return turn;
    }

    /**
     * Sets the current turn in this game.
     *
     * @param newTurn The new <code>Turn</code> to set.
     */
    public void setTurn(Turn newTurn) {
        turn = newTurn;
    }

    /**
     * Get the age for the current turn.
     *
     * @return The age (0-2).
     */
    public int getAge() {
        return getSpecification().getAge(turn);
    }
    
    /**
     * Get the combat model in this game.
     *
     * @return The <code>CombatModel</code>.
     */
    public final CombatModel getCombatModel() {
        return combatModel;
    }

    /**
     * Set the game combat model.
     *
     * @param newCombatModel The new <code>CombatModel</code> value.
     */
    public final void setCombatModel(final CombatModel newCombatModel) {
        this.combatModel = newCombatModel;
    }

    /**
     * Has the Spanish Succession event occured?
     *
     * @return True if the Spanish Succession has occurred.
     */
    public final boolean getSpanishSuccession() {
        return spanishSuccession;
    }

    /**
     * Set the Spanish Succession value.
     *
     * @param spanishSuccession The new Spanish Succession value.
     */
    public final void setSpanishSuccession(final boolean spanishSuccession) {
        this.spanishSuccession = spanishSuccession;
    }

    /**
     * Get the identifier for the initial active unit.
     *
     * @return The active unit identifier, if any.
     */
    public Unit getInitialActiveUnit() {
        return (this.initialActiveUnitId == null) ? null
            : getFreeColGameObject(this.initialActiveUnitId, Unit.class);
    }

    /**
     * Set the identifier for the initial active unit.
     *
     * @param initialActiveUnitId The identifier for the current active unit.
     */
    public void setInitialActiveUnitId(String initialActiveUnitId) {
        this.initialActiveUnitId = initialActiveUnitId;
    }
        
    /**
     * Sets the <code>FreeColGameObjectListener</code> attached to this game.
     *
     * @param l The new <code>FreeColGameObjectListener</code>.
     */
    public void setFreeColGameObjectListener(FreeColGameObjectListener l) {
        freeColGameObjectListener = l;
    }

    /**
     * Notify a listener (if any) of a new game object.
     *
     * @param id The object identifier.
     * @param o The new <code>FreeColGameObject</code>.
     */
    public void notifySetFreeColGameObject(String id, FreeColGameObject o) {
        if (freeColGameObjectListener != null)
			freeColGameObjectListener.setFreeColGameObject(id, o);
    }

    /**
     * Notify a listener (if any) of that a game object has gone.
     *
     * @param id The object identifier.
     */
    public void notifyRemoveFreeColGameObject(String id) {
        if (freeColGameObjectListener != null)
			freeColGameObjectListener.removeFreeColGameObject(id);
    }

    /**
     * Notify a listener (if any) of that a game object has changed owner.
     *
     * @param source The <code>FreeColGameObject</code> that changed owner.
     * @param oldOwner The old owning <code>Player</code>.
     * @param newOwner The new owning <code>Player</code>.
     */
    public void notifyOwnerChanged(FreeColGameObject source,
                                   Player oldOwner, Player newOwner) {
        if (freeColGameObjectListener != null) {
            freeColGameObjectListener.ownerChanged(source, oldOwner, newOwner);
        }
    }

    /**
     * Maintain the player containers for certain ownables.
     * Mainly useful in the client, informing the player that it has
     * gained or lost an ownable.
     *
     * @param o The <code>Ownable</code> that may have changed.
     * @param oldOwner The previous (possible unchanged) owning
     *     <code>Player</code>.
     */
    public void checkOwners(Ownable o, Player oldOwner) {
        final Player newOwner = o.getOwner();
        if (oldOwner.equals(newOwner)) return;

        if (oldOwner != null && oldOwner.removeOwnable(o))
			oldOwner.invalidateCanSeeTiles();
        if (newOwner != null && newOwner.addOwnable(o))
			newOwner.invalidateCanSeeTiles();
    }


    // Miscellaneous utilities.

    /**
     * Checks if all players are ready to launch.
     *
     * @return True if all players are ready to launch.
     */
    public boolean allPlayersReadyToLaunch() {
        return all(getLivePlayers(null), Player::isReady);
    }

    /**
     * Get all the colonies in the game.
     *
     * @param player An optional <code>Player</code> to omit.
     * @return A list of all the <code>Colony</code>s in the game.
     */
    public List<Colony> getAllColonies(Player player) {
        return toList(flatten(getLivePlayers(player), p -> p.isEuropean(),
                              p -> p.getColonies()));
    }
            
    /**
     * Finds a settlement by name.
     *
     * @param name The name of the <code>Settlement</code>.
     * @return The <code>Settlement</code> found, or <code>null</code>
     *     if there is no known <code>Settlement</code> with the
     *     specified name (the settlement might not be visible to a client).
     */
    public Settlement getSettlementByName(String name) {
        for (Player p : getLivePlayers(null))
			for (Settlement $ : p.getSettlements())
				if (name.equals($.getName()))
					return $;
        return null;
    }

    /**
     * Helper function to get the source object of a message in this game.
     *
     * @param message The <code>ModelMessage</code> to find the object in.
     * @return The source object.
     */
    public FreeColGameObject getMessageSource(ModelMessage message) {
        return getFreeColGameObject(message.getSourceId());
    }

    /**
     * Helper function to get the object to display with a message in
     * this game.
     *
     * @param m The <code>ModelMessage</code> to find the object in.
     * @return An object to display.
     */
    public FreeColObject getMessageDisplay(ModelMessage m) {
        String id = m.getDisplayId() == null ? m.getSourceId() : m.getDisplayId();
        return getFreeColGameObject(id) == null ? theObjectIdIsNull(id) : getFreeColGameObject(id);
    }

	private FreeColObject theObjectIdIsNull(String id) {
		FreeColObject $;
		try {
			$ = getSpecification().findType(id);
		} catch (Exception e) {
			$ = null;
		}
		return $;
	}

    /**
     * Gets the statistics of this game.
     *
     * @return A <code>Map</code> of the statistics.
     */
    public java.util.Map<String, String> getStatistics() {
        java.util.Map<String, String> $ = new HashMap<>();

        // Memory
        System.gc();
        final long free = Runtime.getRuntime().freeMemory()/(1024*1024);
        final long total = Runtime.getRuntime().totalMemory()/(1024*1024);
        final long max = Runtime.getRuntime().maxMemory()/(1024*1024);
        $.put("freeMemory", Long.toString(free));
        $.put("totalMemory", Long.toString(total));
        $.put("maxMemory", Long.toString(max));

        // Game objects
        java.util.Map<String, Long> objStats = new HashMap<>();
        long disposed = 0;
        for (FreeColGameObject fcgo : getFreeColGameObjects()) {
            String className = fcgo.getClass().getSimpleName();
            if (!objStats.containsKey(className))
				objStats.put(className, ((long) 1));
			else {
				Long count = objStats.get(className);
				++count;
				objStats.put(className, count);
			}
            if (fcgo.isDisposed()) ++disposed;
        }
        $.put("disposed", Long.toString(disposed));
        for (Entry<String, Long> entry : objStats.entrySet())
			$.put(entry.getKey(), Long.toString(entry.getValue()));

        return $;
    }

    /**
     * Get a location class from an identifier.
     *
     * @param id The identifier to dissect.
     * @return The location class.
     */
    public static Class<? extends FreeColGameObject> getLocationClass(String id) {
        String tag = FreeColObject.getIdType(id);
        tag = Character.toUpperCase(tag.charAt(0)) + tag.substring(1);
        return locationClasses.get(tag);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public int checkIntegrity(boolean fix) {
        int $ = super.checkIntegrity(fix);
        final LogBuilder lb = new LogBuilder(512);
        lb.add("Uninitialized game ids: ");
        lb.mark();
        final Iterator<FreeColGameObject> iterator = getFreeColGameObjectIterator();
        while (iterator.hasNext()) {
            FreeColGameObject fcgo = iterator.next();
            if (fcgo == null)
				lb.add(" null-fcgo");
			else {
				if (fcgo.isInitialized())
					continue;
				lb.add(" ", fcgo.getId(), "(", lastPart(fcgo.getClass().getName(), "."), ")");
			}
            if (!fix)
				$ = -1;
			else {
				iterator.remove();
				$ = Math.min($, 0);
			}
        }
        if (lb.grew()) {
            if (fix) lb.add(" (dropped)");
            lb.log(logger, Level.WARNING);
        }

        final Map map = getMap();
        if (map != null)
			$ = Math.min($, getMap().checkIntegrity(fix));
        for (Player player : getPlayers())
			$ = Math.min($, player.checkIntegrity(fix));
        return $;
    }


    // Override FreeColObject

    /**
     * {@inheritDoc}
     */
    @Override
    public Specification getSpecification() {
        return this.specification;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void setSpecification(Specification s) {
        this.specification = s;
    }
    
    /**
     * {@inheritDoc}
     */
    @Override
    public Game getGame() {
        return this; // The game must be itself!
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void setGame(Game g) {
        // Do nothing, however do not complain at attempts to set as
        // the constructor will try to initialize to null, because we
        // can not yet pass "this" to the FreeColGameObject constructor.
    }
    

    // Override Object
    //
    // Two games are not the same just because they have the same
    // identifier, but to avoid having to check everything in the Game
    // just insist on object equality for the equals() test, and
    // accept the basic id-based hashCode().

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean equals(Object o) {
        return o == this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public int hashCode() {
        return Utils.hashCode(getId());
    }


    // Serialization

    private static final String CIBOLA_TAG = "cibola";
    private static final String CURRENT_PLAYER_TAG = "currentPlayer";
    private static final String INITIAL_ACTIVE_UNIT_ID = "initialActiveUnitId";
    private static final String NEXT_ID_TAG = "nextId";
    private static final String SPANISH_SUCCESSION_TAG = "spanishSuccession";
    private static final String TURN_TAG = "turn";
    private static final String UUID_TAG = "UUID";
    // @compat 0.10.x
    private static final String OLD_NEXT_ID_TAG = "nextID";
    // end @compat 0.10.x


    /**
     * {@inheritDoc}
     */
    @Override
    protected void writeAttributes(FreeColXMLWriter xw) throws XMLStreamException {
        super.writeAttributes(xw);

        if (xw.validForSave())
			xw.writeAttribute(NEXT_ID_TAG, nextId);

        xw.writeAttribute(UUID_TAG, getUUID());

        xw.writeAttribute(TURN_TAG, getTurn().getNumber());

        xw.writeAttribute(SPANISH_SUCCESSION_TAG, spanishSuccession);

        if (initialActiveUnitId != null)
			xw.writeAttribute(INITIAL_ACTIVE_UNIT_ID, initialActiveUnitId);

        if (currentPlayer != null)
			playerIsNotNull(xw);
    }

	private void playerIsNotNull(FreeColXMLWriter xw) throws XMLStreamException {
		xw.writeAttribute(CURRENT_PLAYER_TAG, currentPlayer);
	}

    /**
     * {@inheritDoc}
     */
    @Override
    protected void writeChildren(FreeColXMLWriter xw) throws XMLStreamException {
        super.writeChildren(xw);

        specification.toXML(xw);

        for (String cityName : NameCache.getCitiesOfCibola()) {
            // Preserve existing order
            xw.writeStartElement(CIBOLA_TAG);

            xw.writeAttribute(ID_ATTRIBUTE_TAG, cityName);

            xw.writeEndElement();
        }

        nationOptions.toXML(xw);

        final List<Player> players = toSortedList(getPlayers());
        final Player unknown = getUnknownEnemy();
        if (unknown != null) players.add(unknown);
        for (Player p : players) p.toXML(xw);

        if (map != null) map.toXML(xw);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected void readAttributes(FreeColXMLReader xr) throws XMLStreamException {
        super.readAttributes(xr);

        nextId = xr.getAttribute(NEXT_ID_TAG, -1);
        // @compat 0.10.x
        if (nextId < 0) nextId = xr.getAttribute(OLD_NEXT_ID_TAG, 0);
        // end @compat

        String str = xr.getAttribute(UUID_TAG, (String)null);
        if (str != null)
			getAttributeStringGameClass(str);

        turn = new Turn(xr.getAttribute(TURN_TAG, 1));

        spanishSuccession = xr.getAttribute(SPANISH_SUCCESSION_TAG, false);

        initialActiveUnitId = xr.getAttribute(INITIAL_ACTIVE_UNIT_ID,
                                              (String)null);
    }

	private void getAttributeStringGameClass(String s) {
		try {
			this.uuid = UUID.fromString(s);
		} catch (IllegalArgumentException iae) {
		}
	}

    /**
     * {@inheritDoc}
     */
    @Override
    protected void readChildren(FreeColXMLReader xr) throws XMLStreamException {
        // Clear containers.
        NameCache.clearCitiesOfCibola();
        players.clear();
        unknownEnemy = null;

        // Special case for the current player.  Defer lookup of the
        // current player tag until we read the children, because that
        // is where the players are defined.
        String current = xr.getAttribute(CURRENT_PLAYER_TAG, (String)null);

        super.readChildren(xr);

        currentPlayer = (current == null) ? null
            : getFreeColGameObject(current, Player.class);

        // Make sure all work locations have rational default production
        // now that all tiles are defined.
        for (Colony c : getAllColonies(null)) c.updateProductionTypes();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected void readChild(FreeColXMLReader xr) throws XMLStreamException {
        final Game game = getGame();
        final String tag = xr.getLocalName();
        //logger.finest("Found game tag " + tag + " id=" + xr.readId());

        if (CIBOLA_TAG.equals(tag)) {
            String cibola = xr.readId();
            // @compat 0.11.3
            final String oldPrefix = "lostCityRumour.cityName";
            if (cibola.startsWith(oldPrefix)) cibola = "nameCache." + cibola;
            // end @compat 0.11.3
            NameCache.addCityOfCibola(cibola);
            xr.closeTag(CIBOLA_TAG);

        } else if (Map.getTagName().equals(tag))
			map = xr.readFreeColGameObject(game, Map.class);
		else if (NationOptions.getTagName().equals(tag))
			nationOptions = new NationOptions(xr, specification);
		else if (!Player.getTagName().equals(tag))
			if (!Specification.getTagName().equals(tag))
				super.readChild(xr);
			else {
				logger.info(((specification == null) ? "Loading" : "Reloading") + " specification.");
				specification = new Specification(xr);
			}
		else {
			Player player = xr.readFreeColGameObject(game, Player.class);
			if (!player.isUnknownEnemy())
				players.add(player);
			else
				setUnknownEnemy(player);
		}
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String getXMLTagName() { return getTagNameGameClass(); }

    /**
     * Gets the tag name of the root element representing this object.
     *
     * @return "game".
     */
    public static String getTagNameGameClass() {
        return "game";
    }
}