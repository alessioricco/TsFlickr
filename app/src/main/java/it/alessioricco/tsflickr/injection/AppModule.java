package it.alessioricco.tsflickr.injection;

import android.content.Context;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import it.alessioricco.tsflickr.App;
import it.alessioricco.tsflickr.MainActivity;


/**
 * Created by alessioricco on 02/10/2016.
 *
 * The class providing all the factories to be used for dependency injection with dagger
 */

@Module(
        injects = {
                App.class,

                MainActivity.class
        },
        library = true)

public class AppModule {

    private App app; // App: constructor
    private App testApp; // Test: constructor and environment

    /**
     * constructor for the main android app
     * @param app the application itself
     */
    public AppModule(App app) {
        this.app = app;
    }

    /**
     * constructor for unit test
     */
    public AppModule() {
        try {
            if (testApp == null) {
                testApp = new App();
            }
            app = testApp;
        } catch (Exception e)
        {/* do nothing */}
    }

    @Provides @Singleton public Context provideContext() {
        return app;
    }


}
