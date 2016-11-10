package it.alessioricco.tsflickr.activities;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.Robolectric;
import org.robolectric.Shadows;
import org.robolectric.annotation.Config;
import org.robolectric.shadows.ShadowActivity;
import org.robolectric.shadows.ShadowResources;
import org.robolectric.util.ActivityController;

import javax.inject.Inject;

import it.alessioricco.tsflickr.BuildConfig;
import it.alessioricco.tsflickr.robolectric.TestEnvironment;
import it.alessioricco.tsflickr.injection.TestObjectGraphSingleton;
import it.alessioricco.tsflickr.mocks.MockAppWebServer;
import it.alessioricco.tsflickr.robolectric.CustomRobolectricTestRunner;
import okhttp3.mockwebserver.MockResponse;

import static org.assertj.core.api.Java6Assertions.assertThat;

@Config(shadows = { ShadowResources.class },
        sdk = TestEnvironment.sdk,
        constants = BuildConfig.class,
        manifest = TestEnvironment.manifest)
@RunWith(CustomRobolectricTestRunner.class)
public class TestMainActivity {

    @Inject
    MockAppWebServer mockWebServer;

    @Before
    public void init() throws Exception {

        // Init the IoC and inject us
        TestObjectGraphSingleton.init();
        TestObjectGraphSingleton.getInstance().inject(this);

    }

    /**
     * Method executed after any test
     */
    @After
    public void tearDown() {

        TestObjectGraphSingleton.reset();

    }

    @Test
    public void testDummy() throws Exception {}


    /**
     * test what happens when the activity will access the endpoints
     * todo: robolectric has a problem inflating a layout (cannot call visible method)
     *
     * @throws Exception
     */
    @Test
    public void testMainActivityLoadTheFeed() throws Exception {
        // Create the activity
        ActivityController<MainActivity> activityController =
                Robolectric.buildActivity(MainActivity.class)
                        .create()
                        .start()
                        .resume();

        MainActivity activity = activityController.get();
        assertThat(activity).isNotNull();

        ShadowActivity shadowActivity = Shadows.shadowOf(activity);
        assertThat(shadowActivity).isNotNull();
        assertThat(shadowActivity.isFinishing()).isFalse();

        assertThat(activity.recyclerView).isNotNull();
        assertThat(activity.recyclerView.getAdapter()).isNotNull();
        assertThat(activity.recyclerView.getAdapter().getItemCount()).isGreaterThan(0);

    }

    @Test
    public void testMainActivityServerError500() throws Exception {

        mockWebServer.setOverridingResponse(new MockResponse().setResponseCode(500));

        // Create the activity
        ActivityController<MainActivity> activityController =
                Robolectric.buildActivity(MainActivity.class)
                        .create()
                        .start()
                        .resume();

        MainActivity activity = activityController.get();
        assertThat(activity).isNotNull();

        ShadowActivity shadowActivity = Shadows.shadowOf(activity);
        assertThat(shadowActivity).isNotNull();
        assertThat(shadowActivity.isFinishing()).isFalse();

        assertThat(activity.recyclerView).isNotNull();
        assertThat(activity.recyclerView.getAdapter()).isNotNull();
        assertThat(activity.recyclerView.getAdapter().getItemCount()).isEqualTo(0);

    }
}
