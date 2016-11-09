package it.alessioricco.tsflickr.services;

import java.util.List;

import javax.inject.Inject;

import it.alessioricco.tsflickr.api.APIFactory;
import it.alessioricco.tsflickr.api.FlickrAPI;
import it.alessioricco.tsflickr.api.RestAdapterFactory;
import it.alessioricco.tsflickr.injection.ObjectGraphSingleton;
import it.alessioricco.tsflickr.models.JsonFlickrFeed;
import rx.Observable;


/**
 * this service will retrieve data from the Flickr Public Feed
 */
public final class FlickrService {

    private static final String LOG_TAG = "FlickrService";

    private static final String format = "json";
    private static final int nojsoncallback = 1;

    @Inject
    RestAdapterFactory restAdapterFactory;

    public FlickrService() {

        ObjectGraphSingleton.getInstance().inject(this);
    }

    /**
     * retrieve the public feed
     * todo: this is with no parameters, we'll need some other methods with diff params
     * @return
     */
    public Observable<JsonFlickrFeed> getPublicFeed() {

        final FlickrAPI api = APIFactory.createFlickrAPI(restAdapterFactory.createJSONRestAdapter());
        return api.getPublicFlickrFeed("json",nojsoncallback);
    }


}
