package it.alessioricco.tsflickr.services;

import javax.inject.Inject;

import it.alessioricco.tsflickr.api.APIFactory;
import it.alessioricco.tsflickr.api.FlickrAPI;
import it.alessioricco.tsflickr.api.RestAdapterFactory;
import it.alessioricco.tsflickr.injection.ObjectGraphSingleton;
import it.alessioricco.tsflickr.models.FlickrFeed;
import it.alessioricco.tsflickr.utils.StringUtils;
import rx.Observable;


/**
 * this service will retrieve data from the Flickr Public Feed
 */
public final class FlickrService {

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
    public Observable<FlickrFeed> getPublicFeed(final String tag) {

        final FlickrAPI api = APIFactory.createFlickrAPI(restAdapterFactory.createJSONRestAdapter());

        if (StringUtils.isNullOrEmpty(tag)) {
            return api.getPublicFlickrFeed(format, nojsoncallback);
        } else {
            return api.getPublicFlickrFeed(format, nojsoncallback, tag);
        }
    }


}
