package it.alessioricco.tsflickr.api;

import javax.inject.Inject;

import it.alessioricco.tsflickr.injection.TestObjectGraphSingleton;
import it.alessioricco.tsflickr.mocks.MockAppWebServer;

/**
 * Used for testing the RestAdaptorFactory
 * it overrides the getBaseUrl because it will be used with a mock web server
 */
public class ShadowRestAdapterFactory extends RestAdapterFactory{

    @Inject
    MockAppWebServer mockWebServer;

    public ShadowRestAdapterFactory(){
        super();
        TestObjectGraphSingleton.getInstance().inject(this);
    }

    @Override
    protected String getBaseUrl() {
        return mockWebServer.getMockWebServer().url("").toString();
    }


}
