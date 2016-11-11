package it.alessioricco.tsflickr.fragments;


import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Looper;
import android.provider.MediaStore;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.DialogFragment;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.concurrent.ExecutionException;

import butterknife.ButterKnife;
import butterknife.InjectView;
import it.alessioricco.tsflickr.R;
import it.alessioricco.tsflickr.models.GalleryImage;
import it.alessioricco.tsflickr.models.GalleryImages;
import it.alessioricco.tsflickr.utils.ImageDownloader;
import it.alessioricco.tsflickr.utils.StringUtils;


public class FullScreenDialogFragment extends DialogFragment {
    private final String TAG = FullScreenDialogFragment.class.getSimpleName();
    private GalleryImages images;

    @InjectView(R.id.viewpager)
    ViewPager viewPager;

    @InjectView(R.id.title)
    TextView title;

    @InjectView(R.id.author)
    TextView author;

    @InjectView(R.id.timestamp)
    TextView timestamp;

    @InjectView(R.id.fab)
    FloatingActionButton fab;

    @InjectView(R.id.fab_1)
    FloatingActionButton fabBrowser;

    @InjectView(R.id.fab_2)
    FloatingActionButton fabGallery;

    private Animation showFabBrowser;
    private Animation hideFabBrowser;
    private Animation showFabGallery;
    private Animation hideFabGallery;

    private Boolean isMenuOpen = false;
    private String currentUrl = "";
    private String originalPictureUrl = "";

    private int selectedPosition = 0;

    static public FullScreenDialogFragment create() {
        return new FullScreenDialogFragment();
    }

    private DialogInterface.OnDismissListener onDismissListener;

    public void setOnDismissListener(DialogInterface.OnDismissListener onDismissListener) {
        this.onDismissListener = onDismissListener;
    }

    @Override
    public void onDismiss(DialogInterface dialog) {
        super.onDismiss(dialog);
        if (onDismissListener != null) {
            onDismissListener.onDismiss(dialog);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        final View v = inflater.inflate(R.layout.gallery_slideshow, container, false);

        // butterknife
        ButterKnife.inject(this, v);

        images = (GalleryImages) getArguments().getSerializable(getString(R.string.param_images));
        selectedPosition = getArguments().getInt(getString(R.string.param_position));

        Log.e(TAG, "position: " + selectedPosition);
        Log.e(TAG, "images size: " + images.size());

        SlideShowPagerAdapter slideShowPagerAdapter = new SlideShowPagerAdapter();
        viewPager.setAdapter(slideShowPagerAdapter);
        viewPager.addOnPageChangeListener(viewPagerPageChangeListener);

        setCurrentItem(selectedPosition);

        initializeMenu();

        return v;
    }

    private void initializeMenu() {
        showFabBrowser = AnimationUtils.loadAnimation(getContext(), R.anim.fab1_show);
        hideFabBrowser = AnimationUtils.loadAnimation(getContext(), R.anim.fab1_hide);
        showFabGallery = AnimationUtils.loadAnimation(getContext(), R.anim.fab2_show);
        hideFabGallery = AnimationUtils.loadAnimation(getContext(), R.anim.fab2_hide);

        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onToggleMenu();
            }
        });

        fabBrowser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onOpenBrowser();
            }
        });

        fabGallery.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onSaveOnSystemGallery();
            }
        });

    }

    private void showFabMenu() {

        final FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) fabBrowser.getLayoutParams();
        layoutParams.rightMargin += (int) (fabBrowser.getWidth() * 1.7);
        layoutParams.bottomMargin += (int) (fabBrowser.getHeight() * 0.25);
        fabBrowser.setLayoutParams(layoutParams);
        fabBrowser.startAnimation(showFabBrowser);
        fabBrowser.setClickable(true);

        final FrameLayout.LayoutParams layoutParamsfab2 = (FrameLayout.LayoutParams) fabGallery.getLayoutParams();
        layoutParamsfab2.rightMargin += (int) (fabGallery.getWidth() * 1.5);
        layoutParamsfab2.bottomMargin += (int) (fabGallery.getHeight() * 1.5);
        fabGallery.setLayoutParams(layoutParamsfab2);
        fabGallery.startAnimation(showFabGallery);
        fabGallery.setClickable(true);

    }

    private void hideFabMenu() {

        final FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) fabBrowser.getLayoutParams();
        layoutParams.rightMargin -= (int) (fabBrowser.getWidth() * 1.7);
        layoutParams.bottomMargin -= (int) (fabBrowser.getHeight() * 0.25);
        fabBrowser.setLayoutParams(layoutParams);
        fabBrowser.startAnimation(hideFabBrowser);
        fabBrowser.setClickable(false);


        final FrameLayout.LayoutParams layoutParamsfab2 = (FrameLayout.LayoutParams) fabGallery.getLayoutParams();
        layoutParamsfab2.rightMargin -= (int) (fabGallery.getWidth() * 1.5);
        layoutParamsfab2.bottomMargin -= (int) (fabGallery.getHeight() * 1.5);
        fabGallery.setLayoutParams(layoutParamsfab2);
        fabGallery.startAnimation(hideFabGallery);
        fabGallery.setClickable(true);
    }

    private void setCurrentItem(int position) {
        viewPager.setCurrentItem(position, false);
        showMetaInfo(selectedPosition);
    }

    //  page change listener
    ViewPager.OnPageChangeListener viewPagerPageChangeListener = new ViewPager.OnPageChangeListener() {

        @Override
        public void onPageSelected(int position) {
            showMetaInfo(position);
        }

        @Override
        public void onPageScrolled(int arg0, float arg1, int arg2) {

        }

        @Override
        public void onPageScrollStateChanged(int arg0) {

        }
    };

    private void showMetaInfo(int index) {
        final GalleryImage image = images.get(index);
        if (image == null) {
            return;
        }
        title.setText(image.getTitle());
        timestamp.setText(image.getTimestamp());
        author.setText(image.getAuthor());
        currentUrl = image.getUrl();
        originalPictureUrl = image.getOriginal();
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setStyle(DialogFragment.STYLE_NORMAL, android.R.style.Theme_Black_NoTitleBar_Fullscreen);
    }

    private void onToggleMenu() {
        if (isMenuOpen) {
            isMenuOpen = false;
            hideFabMenu();
            return;
        }
        isMenuOpen= true;
        showFabMenu();
    }

    private void onOpenBrowser() {
        if (StringUtils.isNullOrEmpty(currentUrl)) {
            return;
        }

        Log.d(TAG, currentUrl);

        final Intent intent= new Intent(Intent.ACTION_VIEW, Uri.parse(currentUrl));
        if (intent == null) {
            return;
        }
        startActivity(intent);
    }

    private void onSaveOnSystemGallery() {
        if (StringUtils.isNullOrEmpty(originalPictureUrl)) {
            return;
        }

        final ProgressDialog pDialog = new ProgressDialog(getContext());
        pDialog.setMessage(getString(R.string.downloading));
        pDialog.show();

        new AsyncTask<Void, Void, Bitmap>() {
            @Override
            protected Bitmap doInBackground(Void... params) {
                Looper.prepare();
                Bitmap bitmap = null;
                try {
                    bitmap = ImageDownloader.getBitmap(getContext(),originalPictureUrl);
                } catch (final ExecutionException | InterruptedException e) {
                    Log.e(TAG, e.getMessage());
                }
                return bitmap;
            }
            @Override
            protected void onPostExecute(Bitmap bitmap) {

                pDialog.dismiss();

                if (bitmap == null) {
                    return;
                }

                if (getActivity() == null) {
                    return;
                }

                try {

                    MediaStore.Images.Media.insertImage(getActivity().getContentResolver(),
                            bitmap,
                            timestamp.getText().toString(),
                            title.getText().toString());

                    Log.d(TAG, "Image loaded");
                    Snackbar.make(viewPager, R.string.picture_downloaded, Snackbar.LENGTH_LONG)
                            .setAction(R.string.show, new View.OnClickListener() {
                                @Override
                                public void onClick(View v) {
                                    Intent i = new Intent(Intent.ACTION_PICK,
                                            android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
                                    startActivity(i);
                                }
                            })
                            .show();

                } catch (Exception e) {
                    e.printStackTrace();
                }

            }
        }.execute();
    }
    /**
     * Pager adapter.
     * Given the index, it will download the fullscreen image and it will display it
     */
    class SlideShowPagerAdapter extends PagerAdapter {

        private LayoutInflater layoutInflater;

        public SlideShowPagerAdapter() {
        }

        @Override
        public Object instantiateItem(ViewGroup container, int position) {

            layoutInflater = (LayoutInflater) getActivity().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            final View view = layoutInflater.inflate(R.layout.gallery_fullscreen, container, false);

            final ImageView imageViewPreview = (ImageView) view.findViewById(R.id.fullscreen_image);

            final GalleryImage image = images.get(position);

            Log.d(TAG, image.getFullScreenImageURL());

            ImageDownloader.go(getContext(), image.getFullScreenImageURL(), imageViewPreview);
            container.addView(view);

            return view;
        }

        @Override
        public int getCount() {
            return images.size();
        }

        @Override
        public boolean isViewFromObject(View view, Object obj) {
            return view == obj;
        }


        @Override
        public void destroyItem(ViewGroup container, int position, Object object) {
            container.removeView((View) object);
        }

    }
}


