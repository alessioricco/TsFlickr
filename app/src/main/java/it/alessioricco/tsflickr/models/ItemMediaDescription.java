package it.alessioricco.tsflickr.models;

import android.util.Patterns;

import java.io.Serializable;

import lombok.Getter;
import lombok.Setter;

/**
 * represent the media description
 * "media": {"m":"https://farm6.staticflickr.com/5807/30248454164_f09d4360d2_m.jpg"},
 *
 * image formats are described here:
 * https://www.flickr.com/services/api/misc.urls.html
 *
 *
 *
 s	quadratino 75 x 75
 q	large square 150x150
 t	miniatura, 100 sul lato più lungo
 m	piccolo, 240 sul lato più lungo
 n	small, 320 on longest side
 -	medio, 500 sul lato più lungo
 z	medio 640, 640 sul lato più lungo
 c	medio 800, 800 sul lato più lungo†
 b	grande, 1024 sul lato più lungo*
 h	grandi 1600, 1600 nel lato più lungo†
 k	grandi 2048, 2048 nel lato più lungo†
 o	immagine originale jpg, gif o png, in base al formato di origine

 assumptions to investigate and test:
 we have lowercase url
 we always receive m values
 we always have .jpg

 *
 */
public class ItemMediaDescription implements Serializable {

    //todo: (this is quick,dirty and buggy) improve the replace algo and use more consts
    @Getter @Setter private String m;

    public String getOriginal() {
        return m.replace("_m.jpg", ".jpg");
    }

    public String getSmallSquare() {
        return m.replace("_m.jpg", "_s.jpg");
    }

    public String getLargeSquare() {
        return m.replace("_m.jpg", "_q.jpg");
    }

    public String getMedium() {
        return m.replace("_m.jpg", "_z.jpg");
    }

    public String getBig() {
        return m.replace("_m.jpg", "_b.jpg");
    }

    public boolean isValid() {
        return isValid(m);
    }

    private boolean isValid(final String url) {
        if (url == null || url.length() ==0) {
            return false;
        }
        return Patterns.WEB_URL.matcher(url).matches();
    }

}
