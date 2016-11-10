package it.alessioricco.tsflickr.fragments;


import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.util.Log;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;

import java.util.ArrayList;

import butterknife.ButterKnife;
import butterknife.InjectView;
import it.alessioricco.tsflickr.R;
import it.alessioricco.tsflickr.models.GalleryImage;


public class FullScreenDialogFragment extends DialogFragment {
    private final String TAG = FullScreenDialogFragment.class.getSimpleName();
    private ArrayList<GalleryImage> images;

    @InjectView(R.id.viewpager)
    ViewPager viewPager;

    @InjectView(R.id.title)
    TextView title;

    @InjectView(R.id.timestamp)
    TextView timestamp;

    private SlideShowPagerAdapter slideShowPagerAdapter;
    private int selectedPosition = 0;

    static public FullScreenDialogFragment create() {
        FullScreenDialogFragment f = new FullScreenDialogFragment();
        return f;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        final View v = inflater.inflate(R.layout.gallery_slideshow, container, false);

        // butterknife
        ButterKnife.inject(this, v);

        images = (ArrayList<GalleryImage>) getArguments().getSerializable(getString(R.string.param_images));
        selectedPosition = getArguments().getInt(getString(R.string.param_position));

        Log.e(TAG, "position: " + selectedPosition);
        Log.e(TAG, "images size: " + images.size());

        slideShowPagerAdapter = new SlideShowPagerAdapter();
        viewPager.setAdapter(slideShowPagerAdapter);
        viewPager.addOnPageChangeListener(viewPagerPageChangeListener);

        setCurrentItem(selectedPosition);

        return v;
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
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setStyle(DialogFragment.STYLE_NORMAL, android.R.style.Theme_Black_NoTitleBar_Fullscreen);
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

            Glide.with(getActivity()).load(image.getFullScreenImageURL())
                    .thumbnail(0.5f)
                    .crossFade()
                    .diskCacheStrategy(DiskCacheStrategy.ALL)
                    .into(imageViewPreview);

            container.addView(view);

            return view;
        }

        @Override
        public int getCount() {
            return images.size();
        }

        @Override
        public boolean isViewFromObject(View view, Object obj) {
            return view == ((View) obj);
        }


        @Override
        public void destroyItem(ViewGroup container, int position, Object object) {
            container.removeView((View) object);
        }
    }
}


