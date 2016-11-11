package it.alessioricco.tsflickr.utils;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;

import java.util.concurrent.ExecutionException;

import static android.R.attr.bitmap;

/**
 * Images downloader
 * encapsulate glide
 */
public class ImageDownloader {

    public static void go(final Context context, final String url, final ImageView destination) {
        Glide.with(context).load(url)
                .thumbnail(0.5f)
                .crossFade()
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .into(destination);

    }

    public static Bitmap getBitmap(final Context context, final String url) throws ExecutionException, InterruptedException {
        return Glide.
                with(context).
                load(url).
                asBitmap().
                into(-1,-1).
                get();
    }

}
