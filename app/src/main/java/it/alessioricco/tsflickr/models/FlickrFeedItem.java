package it.alessioricco.tsflickr.models;

import java.io.Serializable;

import lombok.Getter;
import lombok.Setter;

/**
 * flickr feed singe item
 */
public class FlickrFeedItem  implements Serializable {

    @Getter @Setter private String title;
    @Getter @Setter private String link;
    @Getter @Setter private ItemMediaDescription media;
    @Getter @Setter private String date_taken;
    @Getter @Setter private String description;
    @Getter @Setter private String published;
    @Getter @Setter private String author;
    @Getter @Setter private String author_id;
    @Getter @Setter private String tags;
}
