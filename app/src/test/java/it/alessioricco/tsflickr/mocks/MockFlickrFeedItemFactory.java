package it.alessioricco.tsflickr.mocks;

import com.google.gson.Gson;

import it.alessioricco.tsflickr.models.FlickrFeedItem;


public class MockFlickrFeedItemFactory {
    final static String rawJsonItem = "{\n"+
            "\t\t\t\"title\": \"Slowly getting my Chiclines set. \uD83D\uDE04Finished Anya\\'s face up, but will definitely redo it. At least she has a face for this weekend\\'s meetup! Plz excuse nanuri on a ws body. His is in pieces being cleaned!\",\n"+
            "\t\t\t\"link\": \"https://www.flickr.com/photos/redmaiko/30243888543/\",\n"+
            "\t\t\t\"media\": {\"m\":\"https://farm6.staticflickr.com/5466/30243888543_b9228b3c33_m.jpg\"},\n"+
            "\t\t\t\"date_taken\": \"2016-11-09T09:08:00-08:00\",\n"+
            "\t\t\t\"description\": \" <p><a href=\\\"https://www.flickr.com/people/redmaiko/\\\">redmaiko<\\/a> posted a photo:<\\/p> <p><a href=\\\"https://www.flickr.com/photos/redmaiko/30243888543/\\\" title=\\\"Slowly getting my Chiclines set. \uD83D\uDE04Finished Anya\\'s face up, but will definitely redo it. At least she has a face for this weekend\\'s meetup! Plz excuse nanuri on a ws body. His is in pieces being cleaned!\\\"><img src=\\\"https://farm6.staticflickr.com/5466/30243888543_b9228b3c33_m.jpg\\\" width=\\\"240\\\" height=\\\"240\\\" alt=\\\"Slowly getting my Chiclines set. \uD83D\uDE04Finished Anya\\'s face up, but will definitely redo it. At least she has a face for this weekend\\'s meetup! Plz excuse nanuri on a ws body. His is in pieces being cleaned!\\\" /><\\/a><\\/p> \",\n"+
            "\t\t\t\"published\": \"2016-11-09T15:08:00Z\",\n"+
            "\t\t\t\"author\": \"nobody@flickr.com (redmaiko)\",\n"+
            "\t\t\t\"author_id\": \"28373086@N07\",\n"+
            "\t\t\t\"tags\": \"instagramapp square squareformat iphoneography uploaded:by=instagram nashville\"\n"+
            "\t   }";

    public static FlickrFeedItem createFlickrFeedItem() {
        return createFlickrFeedItem(rawJsonItem);
    }

    public static FlickrFeedItem createFlickrFeedItem(final String rawJsonFeed) {
        return new Gson().fromJson(rawJsonFeed, FlickrFeedItem.class);
    }

}
