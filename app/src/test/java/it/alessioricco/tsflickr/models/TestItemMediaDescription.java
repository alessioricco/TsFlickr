package it.alessioricco.tsflickr.models;

import org.junit.Test;

import it.alessioricco.tsflickr.mocks.MockItemMediaDescriptionFactory;

import static org.assertj.core.api.Java6Assertions.assertThat;


public class TestItemMediaDescription {
    @Test
    public void testMediaIsNotEmptyAfterSerialization() throws Exception {

        final ItemMediaDescription item = MockItemMediaDescriptionFactory.createItemMediaDescription();
        assertThat(item).isNotNull();

        assertThat(item.getM()).isNotNull();
        assertThat(item.getM()).isNotEmpty();

    }
}
