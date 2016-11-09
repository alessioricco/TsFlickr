package it.alessioricco.tsflickr.models;

import java.io.Serializable;

import lombok.Getter;
import lombok.Setter;

/**
 * represent the media description
 * "media": {"m":"https://farm6.staticflickr.com/5807/30248454164_f09d4360d2_m.jpg"},
 */
public class ItemMediaDescription implements Serializable {
    @Getter @Setter private String m;
}
