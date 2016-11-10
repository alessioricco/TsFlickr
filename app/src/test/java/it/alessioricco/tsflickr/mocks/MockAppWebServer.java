package it.alessioricco.tsflickr.mocks;

import java.io.IOException;

import lombok.Getter;
import lombok.Setter;
import okhttp3.mockwebserver.Dispatcher;
import okhttp3.mockwebserver.MockResponse;
import okhttp3.mockwebserver.MockWebServer;
import okhttp3.mockwebserver.RecordedRequest;

/**
 * this is a mock web server that will handle all the
 * mock calls from the app
 */
public class MockAppWebServer {

    final private @Getter
    MockWebServer mockWebServer;

    // to force a response
    private @Setter
    MockResponse overridingResponse;

    /**
     * here will set all the responses we want to test
     */
    private final Dispatcher dispatcher = new Dispatcher() {

        @Override
        public MockResponse dispatch(RecordedRequest request) throws InterruptedException {

            if (overridingResponse != null) {
                // just once
                final MockResponse tmpMockResponse = overridingResponse;
                overridingResponse = null;
                return tmpMockResponse;
            }

            //todo: improve this test
            if (request.getPath().equals("/services/feeds/photos_public.gne?format=json&nojsoncallback=1")){
                final String response = MockFlickrFeedFactory.getRawJsonFlickrFeed();
                return new MockResponse()
                        .setResponseCode(200)
                        .addHeader("Content-Type", "application/json; charset=utf-8")
                        .addHeader("Cache-Control", "no-cache")
                        .setBody(response);
            }

            //HTTP/1.1 404 Client Error
            return new MockResponse().setResponseCode(404);

        }
    };

    /**
     * construct the mock web server
     */
    public MockAppWebServer() {
        mockWebServer = new MockWebServer();
        mockWebServer.setDispatcher(dispatcher);
    }

    /**
     * start the mock web server
     * @throws IOException
     */
    public void start() throws IOException {
        mockWebServer.start();
    }

    /**
     * shutdown the mock web server
     */
    public void shutdown(){
        try {
            mockWebServer.shutdown();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }



}
