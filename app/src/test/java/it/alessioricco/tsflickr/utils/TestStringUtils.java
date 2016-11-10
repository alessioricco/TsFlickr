package it.alessioricco.tsflickr.utils;


import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import it.alessioricco.tsflickr.models.FlickrFeed;

import static org.assertj.core.api.Java6Assertions.assertThat;

public class TestStringUtils {


    @Test
    public void testNullString() throws Exception {
        final String nullString = null;

        assertThat(StringUtils.isNullOrEmpty(nullString)).isTrue();
    }

    @Test
    public void testEmptyString() throws Exception {
        final String emptyString = "";

        assertThat(StringUtils.isNullOrEmpty(emptyString)).isTrue();
    }

    @Test
    public void testNonEmptyString() throws Exception {
        final String nonEmptyString = "non empty string";

        assertThat(StringUtils.isNullOrEmpty(nonEmptyString)).isFalse();
    }

    @Test
    public void testTrasformDate() throws Exception {

        //todo: the flickr format converter must be implemented
        assertThat(StringUtils.trasformDate("2016-11-09T17:14:36-08:00")).isNotNull();
        assertThat(StringUtils.trasformDate("2016-11-09T17:14:36-08:00")).isNotEmpty();


    }
}
