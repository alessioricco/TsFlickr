package it.alessioricco.tsflickr.services;

import android.util.Log;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.annotation.Config;
import org.robolectric.shadows.ShadowResources;

import javax.inject.Inject;

import it.alessioricco.tsflickr.robolectric.TestEnvironment;
import it.alessioricco.tsflickr.injection.TestObjectGraphSingleton;
import it.alessioricco.tsflickr.mocks.MockAppWebServer;
import it.alessioricco.tsflickr.models.FlickrFeed;
import it.alessioricco.tsflickr.robolectric.CustomRobolectricTestRunner;
import okhttp3.mockwebserver.MockResponse;
import rx.Observable;
import rx.Subscriber;
import rx.android.BuildConfig;

import static org.assertj.core.api.Java6Assertions.assertThat;

@Config(shadows = { ShadowResources.class },
        sdk = TestEnvironment.sdk,
        constants = BuildConfig.class,
        manifest = TestEnvironment.manifest)
@RunWith(CustomRobolectricTestRunner.class)
public class TestFlickrService {

    private static String LOG_TAG = "TestFlickrService";

    @Inject
    MockAppWebServer mockWebServer;
    @Inject
    FlickrService flickrService;

    @Before
    public void init() throws Exception {

        TestObjectGraphSingleton.init();
        TestObjectGraphSingleton.getInstance().inject(this);
        mockWebServer.start();
    }

    /**
     * Method executed after any test
     */
    @After
    public void tearDown() {
        mockWebServer.shutdown();
    }

    /**
     * server return a 500
     * we expect an error
     * @throws Exception
     */
    @Test
    public void testFlickrPublicFeediResponseCodeWillBe500() throws Exception {

        final Observable<FlickrFeed> market = flickrService.getPublicFeed("");

        mockWebServer.setOverridingResponse(new MockResponse().setResponseCode(500));

        market.toBlocking()
                .subscribe(new Subscriber<FlickrFeed>() {

                    @Override
                    public void onCompleted() {
                        assert(false);
                    }

                    @Override
                    public void onError(Throwable e) {
                        assertThat(e).isNotNull();
                    }

                    @Override
                    public void onNext(FlickrFeed feed) {
                        assert(false);
                    }
                });
    }



    /**
     * test server returning empty string
     * we expect an error
     * @throws Exception
     */
    @Test
    public void testFlickrPublicFeediResponseWillBeEmpty() throws Exception {

        final String body = "";

        final Observable<FlickrFeed> market = flickrService.getPublicFeed("");

        mockWebServer.setOverridingResponse(new MockResponse().setResponseCode(200).setBody(body));

        market.toBlocking()
                .subscribe(new Subscriber<FlickrFeed>() {

                    @Override
                    public void onCompleted() {
                        assert(false);
                    }

                    @Override
                    public void onError(Throwable e) {
                        assert(true);
                    }

                    @Override
                    public void onNext(FlickrFeed feed) {
                        assert(false);
                    }
                });
    }


    /**
     * server return a 200, we expect a list of json values
     * @throws Exception
     */
    @Test
    public void testFlickrPublicFeediResponseCodeWillBe200() throws Exception {

        final Observable<FlickrFeed> market = flickrService.getPublicFeed("");

        market.toBlocking()
                .subscribe(new Subscriber<FlickrFeed>() {

                    @Override
                    public void onCompleted() {
                        assert(true);
                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.d(LOG_TAG, e.getLocalizedMessage(), e);
                        assertThat(e.getLocalizedMessage()).isEmpty(); // it will fail
                    }

                    @Override
                    public void onNext(FlickrFeed feed) {
                        assertThat(feed).isNotNull();
                    }
                });
    }


}
