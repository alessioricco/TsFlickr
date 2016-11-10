package it.alessioricco.tsflickr.models;

import android.util.Patterns;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.annotation.Config;
import org.robolectric.shadows.ShadowResources;

import it.alessioricco.tsflickr.TestEnvironment;
import it.alessioricco.tsflickr.mocks.MockItemMediaDescriptionFactory;
import it.alessioricco.tsflickr.util.CustomRobolectricTestRunner;
import rx.android.BuildConfig;

import static org.assertj.core.api.Java6Assertions.assertThat;

@Config(shadows = { ShadowResources.class },
        sdk = TestEnvironment.sdk,
        constants = BuildConfig.class,
        manifest = TestEnvironment.manifest)
@RunWith(CustomRobolectricTestRunner.class)
public class TestItemMediaDescription {
    @Test
    public void testMediaIsNotEmptyAfterSerialization() throws Exception {

        final ItemMediaDescription item = MockItemMediaDescriptionFactory.createItemMediaDescription();
        assertThat(item).isNotNull();
        assertThat(item.isValid()).isTrue();

        assertThat(item.getM()).isNotNull();
        assertThat(item.getM()).isNotEmpty();

    }

    @Test
    public void testMediaFormats() throws Exception {

        final ItemMediaDescription item = MockItemMediaDescriptionFactory.createItemMediaDescription();

        assertThat(item.getOriginal().replace(".jpg","_m.jpg")).isEqualTo(item.getM());
        assertThat(item.getOriginal().endsWith(".jpg"));
        assertThat(item.getSmallSquare().endsWith("_s.jpg"));
        assertThat(item.getMedium().endsWith("_z.jpg"));
        assertThat(item.getMedium().endsWith("_b.jpg"));

        assertThat(item.getM()).isNotEqualTo(item.getOriginal());
        assertThat(item.getM()).isNotEqualTo(item.getSmallSquare());
        assertThat(item.getM()).isNotEqualTo(item.getMedium());
        assertThat(item.getM()).isNotEqualTo(item.getBig());

        // valid url (robolectric)
        assertThat(Patterns.WEB_URL.matcher(item.getOriginal()).matches()).isTrue();
        assertThat(Patterns.WEB_URL.matcher(item.getSmallSquare()).matches()).isTrue();
        assertThat(Patterns.WEB_URL.matcher(item.getMedium()).matches()).isTrue();
        assertThat(Patterns.WEB_URL.matcher(item.getBig()).matches()).isTrue();
        assertThat(Patterns.WEB_URL.matcher(item.getM()).matches()).isTrue();

    }
}
