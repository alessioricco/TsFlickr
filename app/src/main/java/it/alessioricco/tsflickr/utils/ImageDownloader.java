package it.alessioricco.tsflickr.utils;

import android.content.Context;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;

/**
 * Images downloader
 * encapsulate glide
 */
public class ImageDownloader {

    public static void go(Context context, String url, ImageView destination) {
        Glide.with(context).load(url)
                .thumbnail(0.5f)
                .crossFade()
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .into(destination);

    }

}
