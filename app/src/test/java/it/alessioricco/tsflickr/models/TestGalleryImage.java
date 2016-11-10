package it.alessioricco.tsflickr.models;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.annotation.Config;
import org.robolectric.shadows.ShadowResources;

import it.alessioricco.tsflickr.robolectric.TestEnvironment;
import it.alessioricco.tsflickr.mocks.MockFlickrFeedItemFactory;
import it.alessioricco.tsflickr.robolectric.CustomRobolectricTestRunner;
import rx.android.BuildConfig;

import static org.assertj.core.api.Java6Assertions.assertThat;


@Config(shadows = { ShadowResources.class },
        sdk = TestEnvironment.sdk,
        constants = BuildConfig.class,
        manifest = TestEnvironment.manifest)
@RunWith(CustomRobolectricTestRunner.class)
public class TestGalleryImage {

    GalleryImage model;

    @Before
    public void init() throws Exception {

    }

    /**
     * Method executed after any test
     */
    @After
    public void tearDown() {

    }

    @Test(expected=IllegalArgumentException.class)
    public void testConstructorWithNullParameter() throws Exception {
        model = new GalleryImage(null);
        assertThat(model).isNotNull();
    }

    @Test(expected=IllegalArgumentException.class)
    public void testConstructorWithNotSerializedParameter() throws Exception {
        final FlickrFeedItem feedItem = new FlickrFeedItem();
        model = new GalleryImage(feedItem);
        assertThat(model).isNotNull();

    }

    @Test
    public void testConstructorWithSerializedParameter() throws Exception {
        final FlickrFeedItem feedItem = MockFlickrFeedItemFactory.createFlickrFeedItem();
        model = new GalleryImage(feedItem);
        assertThat(model).isNotNull();

        assertThat(GalleryImage.isValid(feedItem)).isTrue();

        assertThat(model.getTitle()).isEqualTo(feedItem.getTitle());
        assertThat(model.getTimestamp()).isEqualTo(feedItem.getDate_taken());
        assertThat(model.getFullScreenImageURL()).isEqualTo(feedItem.getMedia().getBig());
        assertThat(model.getThumbnailImageURL()).isEqualTo(feedItem.getMedia().getMedium());
    }

}
