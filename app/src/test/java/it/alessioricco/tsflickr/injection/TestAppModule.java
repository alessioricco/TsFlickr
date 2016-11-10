package it.alessioricco.tsflickr.injection;

import android.content.Context;

import org.robolectric.shadows.ShadowApplication;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import it.alessioricco.tsflickr.activities.TestMainActivity;
import it.alessioricco.tsflickr.api.RestAdapterFactory;
import it.alessioricco.tsflickr.api.ShadowRestAdapterFactory;
import it.alessioricco.tsflickr.mocks.MockAppWebServer;
import it.alessioricco.tsflickr.services.TestFlickrService;


@Module(includes = {
        AppModule.class
        },
        injects = {
                // here the list of classes using injection
                MockAppWebServer.class,
                TestFlickrService.class,
                TestMainActivity.class,
                ShadowRestAdapterFactory.class
        },
        library = true, overrides = true)
public class TestAppModule {

    private final Context context;

    TestAppModule() {
        context = ShadowApplication.getInstance().getApplicationContext();
    }

    @Provides
    @Singleton
    public Context getContext() {
        return context;
    }


    @Provides
    @Singleton
    public MockAppWebServer getWebServer() {
        return new MockAppWebServer();
    }

    /**
     * RestAdapter factory
     * used to build a restadapter for the default ticker service endpoint
     * @return a well formed RestAdapterFactory object
     */
    @Provides @Singleton public RestAdapterFactory provideRestAdapter() {
        return new ShadowRestAdapterFactory();
    }

}
