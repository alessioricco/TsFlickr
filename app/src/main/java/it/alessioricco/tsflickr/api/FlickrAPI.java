package it.alessioricco.tsflickr.api;

import java.util.List;

import it.alessioricco.tsflickr.models.JsonFlickrFeed;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;
import rx.Observable;


/**
 * retrofit inteface definition of API rest endpoints
 *
 * documentation:
 * https://www.flickr.com/services/feeds/docs/photos_public
 */
public interface FlickrAPI {

    /**
     *
     * @param id        (optional)
     * @param ids       (optional)
     * @param tags      (optional)
     * @param tagMode   (optional)
     * @param format    (optional) todo: must be json
     * @param lang      (optional) todo: must be taken from the international phone settings ?
     * @return
     */
    @GET("/services/feeds/photos_public.gne")
    Observable<JsonFlickrFeed> getPublicFlickrFeed(@Query("id") String id,
                                                   @Query("ids") String ids,
                                                   @Query("tags") String tags,
                                                   @Query("tagmode") String tagMode,
                                                   @Query("format") String format,
                                                   @Query("lang") String lang);

}
