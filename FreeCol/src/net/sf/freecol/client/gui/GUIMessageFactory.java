package net.sf.freecol.client.gui;

import java.awt.Color;


/**
 * The class <code>GUIMessageFactory</code> implements static methods that return instances of the class <code>{@link GUIMessage}</code>.
 *
 * @generatedBy CodePro at 5/17/16 8:57 PM
 * @author user
 * @version $Revision: 1.0 $
 */
public class GUIMessageFactory
 {
	/**
	 * Prevent creation of instances of this class.
	 *
	 * @generatedBy CodePro at 5/17/16 8:57 PM
	 */
	private GUIMessageFactory() {
	}


	/**
	 * Create an instance of the class <code>{@link GUIMessage}</code>.
	 *
	 * @generatedBy CodePro at 5/17/16 8:57 PM
	 */
	public static GUIMessage createGUIMessage() {
		return new GUIMessage("", Color.BLACK);
	}


	/**
	 * Create an instance of the class <code>{@link GUIMessage}</code>.
	 *
	 * @generatedBy CodePro at 5/17/16 8:57 PM
	 */
	public static GUIMessage createGUIMessage2() {
		return new GUIMessage("0123456789", Color.BLUE);
	}
}