package it.alessioricco.tsflickr.models;

import org.junit.Test;

import it.alessioricco.tsflickr.mocks.MockFlickrFeedItemFactory;

import static org.assertj.core.api.Java6Assertions.assertThat;


/**
 *
 */
public class TestFlickrFeedItem {

    @Test
    public void testConstructor() throws Exception {
        final FlickrFeedItem model = new FlickrFeedItem();
        assertThat(model).isNotNull();
    }

    @Test
    public void testProperties() throws Exception {
        final FlickrFeedItem model = new FlickrFeedItem();

        final String test = "this is a test";
        model.setTitle(test);
        assertThat(model.getTitle()).isEqualTo(test);
    }

    @Test
    public void testModelItemIsNotEmptyAfterSerialization() throws Exception {

        final FlickrFeedItem item = MockFlickrFeedItemFactory.createFlickrFeedItem();
        assertThat(item).isNotNull();

        assertThat(item.getLink()).isNotNull();
        assertThat(item.getLink()).isNotEmpty();

        assertThat(item.getDescription()).isNotNull();
        assertThat(item.getDescription()).isNotEmpty();

        assertThat(item.getAuthor()).isNotNull();
        assertThat(item.getAuthor()).isNotEmpty();

        assertThat(item.getAuthor_id()).isNotNull();
        assertThat(item.getAuthor_id()).isNotEmpty();

        assertThat(item.getDate_taken()).isNotNull();
        assertThat(item.getDate_taken()).isNotEmpty();

        assertThat(item.getMedia()).isNotNull();

        assertThat(item.getTitle()).isNotNull();
        assertThat(item.getTitle()).isNotEmpty();

        assertThat(item.getPublished()).isNotNull();
        assertThat(item.getPublished()).isNotEmpty();

        assertThat(item.getTags()).isNotNull();

    }
}
