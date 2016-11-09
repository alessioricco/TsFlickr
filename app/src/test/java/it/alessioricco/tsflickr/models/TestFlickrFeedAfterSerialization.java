package it.alessioricco.tsflickr.models;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import it.alessioricco.tsflickr.mocks.MockFlickrFeedFactory;

import static org.assertj.core.api.Java6Assertions.assertThat;

/**
 * Unit Test for FlickrFeed Model
 */
public class TestFlickrFeedAfterSerialization {

    FlickrFeed model;

    @Before
    public void init() throws Exception {
        model = MockFlickrFeedFactory.createFlickrFeed();
    }

    /**
     * Method executed after any test
     */
    @After
    public void tearDown() {

    }

    @Test
    public void testConstructor() throws Exception {
        assertThat(model).isNotNull();
    }

    @Test
    public void testModelPropertiesAreNotEmpty() throws Exception {

        assertThat(model.getTitle()).isNotEmpty();
        assertThat(model.getTitle()).isNotNull();

        assertThat(model.getDescription()).isNotNull();

        assertThat(model.getGenerator()).isNotEmpty();
        assertThat(model.getGenerator()).isNotNull();

        assertThat(model.getLink()).isNotEmpty();
        assertThat(model.getLink()).isNotNull();

        assertThat(model.getItems()).isNotNull();
        assertThat(model.getItems().size()).isNotZero();

    }

    @Test
    public void testModelItemsAreNotEmpty() throws Exception {

        assertThat(model.getItems()).isNotNull();
        assertThat(model.getItems().size()).isNotZero();

        for (FlickrFeedItem item: model.getItems()) {

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
}
