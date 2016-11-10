package it.alessioricco.tsflickr.models;

import java.io.Serializable;
import java.util.List;

import lombok.Getter;
import lombok.Setter;


/**
 * public flickr feed model
 *
 * https://api.flickr.com/services/feeds/photos_public.gne?format=json
 *
 */
public class FlickrFeed implements Serializable {

    @Getter @Setter private String title;
    @Getter @Setter private String link;
    @Getter @Setter private String description;
    @Getter @Setter private String modified;
    @Getter @Setter private String generator;

    @Getter @Setter private List<FlickrFeedItem> items;
}
