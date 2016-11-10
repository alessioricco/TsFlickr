package it.alessioricco.tsflickr.models;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;


/**
 * Images Collection (used in adapters)
 */
public class GalleryImages implements Serializable {
    private final List<GalleryImage> images = new ArrayList<>();

    /**
     * retrieve a galleryImage object
     * @param index
     * @return
     */
    public GalleryImage get(final int index) {
        if (index < 0  || index >= images.size()) {
            return null;
        }
        return images.get(index);
    }

    /**
     * add a new GalleryImage object
     * @param item
     */
    public void add(final GalleryImage item) {
        images.add(item);
    }

    /**
     * Clear the list
     */
    public void clear() {
        images.clear();
    }

    /**
     * get the list size
     */
    public int size() {
        return images.size();
    }
}
