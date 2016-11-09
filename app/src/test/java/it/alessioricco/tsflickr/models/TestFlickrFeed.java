package it.alessioricco.tsflickr.models;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import it.alessioricco.tsflickr.api.FlickrAPI;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

import static org.assertj.core.api.Java6Assertions.assertThat;

/**
 * Unit Test for FlickrFeed Model
 */
public class TestFlickrFeed {

    FlickrFeed model;

    @Before
    public void init() throws Exception {
        model = new FlickrFeed();
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
    public void testModelItems() throws Exception {

        final String title = "title";
        model.setTitle(title);
        assertThat(model.getTitle()).isEqualTo(title);

        assertThat(model.getItems()).isNull();

    }


}
