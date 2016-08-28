package fr.kvaternik.adrien.bookstore.model.entity;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Tests for {@link PercentageOffer}.
 */
public class PercentageOfferShould {

    private static final double ACCURACY = 0.001;

    @Test
    public void apply_right_reduction() throws Exception {
        assertEquals(45, new PercentageOffer(10).getReducedPrice(50), ACCURACY);
    }

    @Test
    public void zero_a_negative_price() throws Exception {
        assertEquals(0, new PercentageOffer(110).getReducedPrice(50), ACCURACY);
    }
}