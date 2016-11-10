package it.alessioricco.tsflickr.injection;

import dagger.ObjectGraph;

/**
 * Object graph for Dagger (in Test)
 */
public class TestObjectGraphSingleton {

    static public void init() {

        final TestAppModule[] modules = {
                new TestAppModule()
        };

        ObjectGraphSingleton.reset();
        ObjectGraphSingleton.setInstance(ObjectGraph.create((Object[]) modules));
    }

    static public ObjectGraph getInstance() {
        return ObjectGraphSingleton.getInstance();
    }

    static public void reset() {
        ObjectGraphSingleton.reset();
    }
}
