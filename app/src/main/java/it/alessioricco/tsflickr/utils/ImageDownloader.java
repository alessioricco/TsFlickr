package it.alessioricco.tsflickr.utils;

import android.content.Context;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;

/**
 * Created by alessioricco on 10/11/2016.
 */

public class ImageDownloader {

    public static void go(Context context, String url, ImageView destination) {
        Glide.with(context).load(url)
                .thumbnail(0.5f)
                .crossFade()
                .placeholder(android.R.drawable.presence_away)
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .into(destination);
    }

}
