package it.alessioricco.tsflickr.api;


import retrofit2.Retrofit;

/**
 * Factory for (all) the APIs called in the app
 */
public class APIFactory {

    public static FlickrAPI createFlickrAPI(Retrofit retrofit) {
        return retrofit.create(FlickrAPI.class);
    }

}
