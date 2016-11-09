package it.alessioricco.tsflickr.mocks;

import com.google.gson.Gson;

import it.alessioricco.tsflickr.models.ItemMediaDescription;



public class MockItemMediaDescriptionFactory {

    final static String rawJsonItem = "{\"m\":\"https://farm6.staticflickr.com/5466/30243888543_b9228b3c33_m.jpg\"}";

    public static ItemMediaDescription createItemMediaDescription() {
        return createItemMediaDescription(rawJsonItem);
    }

    public static ItemMediaDescription createItemMediaDescription(final String rawJsonFeed) {
        return new Gson().fromJson(rawJsonFeed, ItemMediaDescription.class);
    }

}
