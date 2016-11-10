package it.alessioricco.tsflickr.api;

import it.alessioricco.tsflickr.models.FlickrFeed;
import retrofit2.http.GET;
import retrofit2.http.Query;
import rx.Observable;


/**
 * retrofit inteface definition of API rest endpoints
 *
 * documentation:
 * https://www.flickr.com/services/feeds/docs/photos_public
 * http://stackoverflow.com/questions/27067970/gson-parsing-with-retrofit-parsing-flickr-json-response
 */
public interface FlickrAPI {

    @GET("/services/feeds/photos_public.gne")
    Observable<FlickrFeed> getPublicFlickrFeed(@Query("format") String format, @Query("nojsoncallback") int noJsonCallback);

    @GET("/services/feeds/photos_public.gne")
    Observable<FlickrFeed> getPublicFlickrFeed(@Query("format") String format, @Query("nojsoncallback") int noJsonCallback, @Query("tags") String tag);

}
