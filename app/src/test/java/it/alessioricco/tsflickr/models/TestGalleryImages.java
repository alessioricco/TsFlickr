package it.alessioricco.tsflickr.models;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.annotation.Config;
import org.robolectric.shadows.ShadowResources;

import it.alessioricco.tsflickr.TestEnvironment;
import it.alessioricco.tsflickr.mocks.MockFlickrFeedItemFactory;
import it.alessioricco.tsflickr.util.CustomRobolectricTestRunner;
import rx.android.BuildConfig;

import static org.assertj.core.api.Java6Assertions.assertThat;


@Config(shadows = { ShadowResources.class },
        sdk = TestEnvironment.sdk,
        constants = BuildConfig.class,
        manifest = TestEnvironment.manifest)
@RunWith(CustomRobolectricTestRunner.class)
public class TestGalleryImages {

    GalleryImages list = new GalleryImages();

    @Before
    public void init() throws Exception {

    }

    /**
     * Method executed after any test
     */
    @After
    public void tearDown() {

    }

    @Test
    public void testConstructor() throws Exception {
        assertThat(list).isNotNull();
    }

    @Test
    public void testGetterWithOutOfBoundIndex() throws Exception {
        assertThat(list.size()).isEqualTo(0);
        assertThat(list.get(-1)).isNull();
        assertThat(list.get(list.size())).isNull();
    }

    @Test
    public void testAddAndGetterWithInBoundIndex() throws Exception {
        assertThat(list.size()).isEqualTo(0);

        list.add(new GalleryImage(MockFlickrFeedItemFactory.createFlickrFeedItem()));
        assertThat(list.size()).isEqualTo(1);
        assertThat(list.get(0)).isNotNull();

        list.add(new GalleryImage(MockFlickrFeedItemFactory.createFlickrFeedItem()));
        assertThat(list.size()).isEqualTo(2);
        assertThat(list.get(1)).isNotNull();

        assertThat(list.get(2)).isNull();

    }

    @Test
    public void testClear() throws Exception {
        assertThat(list.size()).isEqualTo(0);

        list.add(new GalleryImage(MockFlickrFeedItemFactory.createFlickrFeedItem()));
        list.add(new GalleryImage(MockFlickrFeedItemFactory.createFlickrFeedItem()));
        assertThat(list.size()).isEqualTo(2);

        list.clear();
        assertThat(list.size()).isEqualTo(0);

    }

}
