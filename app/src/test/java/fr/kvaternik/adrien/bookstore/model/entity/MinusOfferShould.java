package fr.kvaternik.adrien.bookstore.model.entity;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Tests for {@link MinusOffer}.
 */
public class MinusOfferShould {

    private static final double ACCURACY = 0.001;

    @Test
    public void apply_right_reduction() throws Exception {
        assertEquals(90, new MinusOffer(10).getReducedPrice(100), ACCURACY);
    }

    @Test
    public void zero_a_negative_price() throws Exception {
        assertEquals(0, new MinusOffer(10).getReducedPrice(5), ACCURACY);
    }

    @Test
    public void have_an_unit_euros() throws Exception {
        assertEquals(Offer.UNIT_EUROS, new MinusOffer(10).getUnit());
    }
}