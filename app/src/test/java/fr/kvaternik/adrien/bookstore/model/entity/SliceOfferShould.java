package fr.kvaternik.adrien.bookstore.model.entity;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Tests for {@link SliceOffer}.
 */
public class SliceOfferShould {

    private static final double ACCURACY = 0.001;

    @Test
    public void apply_right_reduction() throws Exception {
        assertEquals(226, new SliceOffer(12, 100).getPriceAfterApplication(250), ACCURACY);
        assertEquals(90, new SliceOffer(10, 100).getPriceAfterApplication(90), ACCURACY);
    }

    @Test
    public void zero_a_negative_price() throws Exception {
        assertEquals(0, new SliceOffer(100, 10).getPriceAfterApplication(50), ACCURACY);
    }
}