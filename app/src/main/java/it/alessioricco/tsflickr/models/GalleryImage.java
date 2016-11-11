package it.alessioricco.tsflickr.models;


import java.io.Serializable;

import it.alessioricco.tsflickr.utils.NetworkStatus;

/**
 * Adapt the FlickerFeedItem
 *
 * todo: we should apply a strategy for decide the right file to download
 * this strategy should choose the right file depending on screen size and connection speed
 *
 */
public final class GalleryImage implements Serializable {

    private final FlickrFeedItem item;
    private final int currentNetworkStatus;

    public GalleryImage(FlickrFeedItem item, int currentNetworkStatus) {
        if (!isValid(item)) {
            throw new IllegalArgumentException("the argument is null or invalid");
        }
        this.currentNetworkStatus = currentNetworkStatus;
        this.item  = item;
    }

    public static boolean isValid(final FlickrFeedItem item) {
        return item != null && item.getMedia() != null && item.getMedia().isValid();
    }

    public final String getThumbnailImageURL() {
        if (currentNetworkStatus == NetworkStatus.WIFI) {
            return item.getMedia().getMedium();
        }
        if (currentNetworkStatus == NetworkStatus.MOBILE) {
            return item.getMedia().getLargeSquare();
        }
        return item.getMedia().getSmallSquare();
    }

    public final String getOriginal() {
        return item.getMedia().getOriginal();
    }

    public final String getFullScreenImageURL() {
        if (currentNetworkStatus == NetworkStatus.WIFI) {
            return item.getMedia().getBig();
        }
        if (currentNetworkStatus == NetworkStatus.MOBILE) {
            return item.getMedia().getMedium();
        }
        return item.getMedia().getMedium();
    }

    public final String getTimestamp() {
        return item.getDate_taken();
    }

    public final String getTitle() {
        return item.getTitle();
    }

    public final String getAuthor() {
        return item.getAuthor();
    }

    public final String getUrl() {
        return item.getLink();
    }
}
