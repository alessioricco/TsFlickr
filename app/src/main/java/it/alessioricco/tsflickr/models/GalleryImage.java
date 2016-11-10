package it.alessioricco.tsflickr.models;


import java.io.Serializable;

/**
 * Adapt the FlickerFeedItem
 */
public final class GalleryImage implements Serializable {

    private final FlickrFeedItem item;

    public GalleryImage(FlickrFeedItem item) {
        this.item  = item;
    }

    public final String getSmall() {
        return item.getMedia().getSmallSquare();
    }

    public final String getMedium() {
        return item.getMedia().getMedium();
    }

    public final String getLarge() {
        return item.getMedia().getBig();
    }

    public final String getTimestamp() {
        return item.getDate_taken();
    }

    public final String getTitle() {
        return item.getTitle();
    }
}
