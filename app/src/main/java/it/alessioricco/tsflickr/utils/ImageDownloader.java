package it.alessioricco.tsflickr.utils;

import android.content.Context;
import android.graphics.Bitmap;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.load.resource.drawable.GlideDrawable;
import com.bumptech.glide.request.RequestListener;
import com.bumptech.glide.request.target.Target;

import java.util.concurrent.ExecutionException;

import it.alessioricco.tsflickr.R;

/**
 * Images downloader
 * encapsulate glide
 */
public class ImageDownloader {

    public static void go(final Context context, final String url, final ImageView destination) {
        Glide.with(context)
                .load(url)
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
