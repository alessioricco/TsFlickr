package it.alessioricco.tsflickr.models;


import java.io.Serializable;

/**
 * Adapt the FlickerFeedItem
 */
public final class GalleryImage implements Serializable {

    private final FlickrFeedItem item;

    public GalleryImage(FlickrFeedItem item) {
        if (!isValid(item)) {
            throw new IllegalArgumentException("the argument is null or invalid");
        }

        this.item  = item;
    }

    public static boolean isValid(final FlickrFeedItem item) {
        if (item == null) {
            return false;
        }
        if (item.getMedia() == null) {
            return false;
        }
        if (! item.getMedia().isValid()) {
            return false;
        }
        return true;
    }

    public final String getThumbnailImageURL() {
        return item.getMedia().getMedium();
    }

    public final String getFullScreenImageURL() {
        return item.getMedia().getBig();
    }

    public final String getTimestamp() {
        return item.getDate_taken();
    }

    public final String getTitle() {
        return item.getTitle();
    }
}
