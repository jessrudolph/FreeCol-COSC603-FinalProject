/*
 *  Copyright (C) 2002-2016   The FreeCol Team
 *
 *  This file is part of FreeCol.
 *
 *  FreeCol is free software: you can redistribute it and/or modify
 *  it under the terms of the GNU General Public License as published by
 *  the Free Software Found+ation, either version 2 of the License, or
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

package net.sf.freecol.common.resources;

import java.io.IOException;
import java.lang.ref.WeakReference;
import java.net.URI;
import java.util.Map;
import java.util.WeakHashMap;
import java.util.logging.Level;
import java.util.logging.Logger;


/**
 * A factory class for creating <code>Resource</code> instances.
 * @see Resource
 */
public class ResourceFactory {

    private static final Logger logger = Logger.getLogger(ResourceFactory.class.getName());

    /**
     * Takes a newly produced Resource.
     */
    public interface ResourceSink {

        void add(ColorResource r);
        void add(FontResource r);
        void add(StringResource r);
        void add(FAFileResource r);
        void add(SZAResource r);
        void add(AudioResource r);
        void add(VideoResource r);
        void add(ImageResource r);

    }

    /**
     * <code>WeakHashMap</code>s to ensure that only one
     * <code>Resource</code> is created given the same
     * <code>URI</code>.
     */
    private static final Map<URI, WeakReference<ColorResource>> colorResources
        = new WeakHashMap<>();
    private static final Map<URI, WeakReference<FontResource>> fontResources
        = new WeakHashMap<>();
    private static final Map<URI, WeakReference<StringResource>> stringResources
        = new WeakHashMap<>();
    private static final Map<URI, WeakReference<FAFileResource>> fafResources
        = new WeakHashMap<>();
    private static final Map<URI, WeakReference<SZAResource>> szaResources
        = new WeakHashMap<>();
    private static final Map<URI, WeakReference<AudioResource>> audioResources
        = new WeakHashMap<>();
    private static final Map<URI, WeakReference<VideoResource>> videoResources
        = new WeakHashMap<>();
    private static final Map<URI, WeakReference<ImageResource>> imageResources
        = new WeakHashMap<>();

    /**
     * Check for previously created resources.
     *
     * @param i The <code>URI</code> used when creating the instance.
     * @param output Where a previously created instance of <code>Resource</code>
     *      with the given <code>URI</code> is put if such an object has
     *      already been created.
     * @return If a Resource is found.
     */
    private static boolean findResource(URI i, ResourceSink output) {
        final WeakReference<ColorResource> crwr = colorResources.get(i);
        if(crwr != null) {
            final ColorResource cr = crwr.get();
            if (cr != null) {
                output.add(cr);
                return true;
            }
        }
        final WeakReference<FontResource> frwr = fontResources.get(i);
        if(frwr != null) {
            final FontResource fr = frwr.get();
            if (fr != null) {
                output.add(fr);
                return true;
            }
        }
        final WeakReference<StringResource> srwr = stringResources.get(i);
        if(srwr != null) {
            final StringResource sr = srwr.get();
            if (sr != null) {
                output.add(sr);
                return true;
            }
        }
        final WeakReference<FAFileResource> farwr = fafResources.get(i);
        if(farwr != null) {
            final FAFileResource far = farwr.get();
            if (far != null) {
                output.add(far);
                return true;
            }
        }
        final WeakReference<SZAResource> szrwr = szaResources.get(i);
        if(szrwr != null) {
            final SZAResource szr = szrwr.get();
            if (szr != null) {
                output.add(szr);
                return true;
            }
        }
        final WeakReference<AudioResource> arwr = audioResources.get(i);
        if(arwr != null) {
            final AudioResource ar = arwr.get();
            if (ar != null) {
                output.add(ar);
                return true;
            }
        }
        final WeakReference<VideoResource> vrwr = videoResources.get(i);
        if(vrwr != null) {
            final VideoResource vr = vrwr.get();
            if (vr != null) {
                output.add(vr);
                return true;
            }
        }
        final WeakReference<ImageResource> irwr = imageResources.get(i);
        if(irwr != null) {
            final ImageResource ir = irwr.get();
            if (ir != null) {
                output.add(ir);
                return true;
            }
        }
        return false;
    }

    /**
     * Returns an instance of <code>Resource</code> with the
     * given <code>URI</code> as the parameter.
     *
     * @param i The <code>URI</code> used when creating the
     *      instance.
     * @param output Where a previously created instance of <code>Resource</code>
     *      with the given <code>URI</code> is put if such an object has
     *      already been created, or a new instance if not.
     */
    public static void createResource(URI i, ResourceSink output) {
        if(findResource(i, output)) {
			return;
		}

        try {
            if ("urn".equals(i.getScheme())) {
				if (i.getSchemeSpecificPart().startsWith(ColorResource.SCHEME)) {
					ColorResource cr = new ColorResource(i);
					output.add(cr);
					colorResources.put(i, new WeakReference<>(cr));
				} else if (i.getSchemeSpecificPart().startsWith(FontResource.SCHEME)) {
					FontResource fr = new FontResource(i);
					output.add(fr);
					fontResources.put(i, new WeakReference<>(fr));
				} else if (i.getPath().endsWith("\"")
                    && i.getPath().lastIndexOf('"',
                            i.getPath().length()-1) >= 0) {
                StringResource sr = new StringResource(i);
                output.add(sr);
                stringResources.put(i, new WeakReference<>(sr));
            } else if (i.getPath().endsWith(".faf")) {
                FAFileResource far = new FAFileResource(i);
                output.add(far);
                fafResources.put(i, new WeakReference<>(far));
            } else if (i.getPath().endsWith(".sza")) {
                SZAResource szr = new SZAResource(i);
                output.add(szr);
                szaResources.put(i, new WeakReference<>(szr));
            } else if (i.getPath().endsWith(".ttf")) {
                FontResource fr = new FontResource(i);
                output.add(fr);
                fontResources.put(i, new WeakReference<>(fr));
            } else if (!i.getPath().endsWith(".wav")) {
				thePathToDo(i, output);
			} else {
				AudioResource ar = new AudioResource(i);
				output.add(ar);
				audioResources.put(i, new WeakReference<>(ar));
			}
			}
        } catch (Exception e) {
            logger.log(Level.WARNING, "Failed to create resource with URI: " + i, e);
        }
    }

	private static void thePathToDo(URI i, ResourceSink output) throws IOException, Exception {
		if (!i.getPath().endsWith(".ogg")) {
			ImageResource ir = new ImageResource(i);
			output.add(ir);
			imageResources.put(i, new WeakReference<>(ir));
		} else if (i.getPath().endsWith(".video.ogg")) {
			VideoResource vr = new VideoResource(i);
			output.add(vr);
			videoResources.put(i, new WeakReference<>(vr));
		} else {
			AudioResource ar = new AudioResource(i);
			output.add(ar);
			audioResources.put(i, new WeakReference<>(ar));
		}
	}

}
