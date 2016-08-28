package fr.kvaternik.adrien.bookstore.model.calculation;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import fr.kvaternik.adrien.bookstore.model.entity.MinusOffer;
import fr.kvaternik.adrien.bookstore.model.entity.Offer;
import fr.kvaternik.adrien.bookstore.model.entity.PercentageOffer;
import fr.kvaternik.adrien.bookstore.model.entity.SliceOffer;

import static org.junit.Assert.*;

/**
 * Tests for {@link OfferOptimizer}.
 */
public class OfferOptimizerShould {

    private OfferOptimizer mOfferOptimizer;

    @Before
    public void setUp() throws Exception {
        mOfferOptimizer = new OfferOptimizer();
    }

    @Test
    public void should_return_null_if_no_offer() throws Exception {
        // action
        Offer bestOffer = mOfferOptimizer.getBestOffer(new ArrayList<Offer>(), 50.0);

        // assertion
        assertNull(bestOffer);
    }

    @Test
    public void should_return_the_best_offer() throws Exception {
        // data preparation
        MinusOffer minusOffer = new MinusOffer(20);
        PercentageOffer percentageOffer = new PercentageOffer(20);
        SliceOffer sliceOffer = new SliceOffer(10, 100);

        ArrayList<Offer> offers = new ArrayList<>();
        offers.add(minusOffer);
        offers.add(percentageOffer);
        offers.add(sliceOffer);

        // action
        Offer bestOffer = mOfferOptimizer.getBestOffer(offers, 200.0);

        // assertion
        assertEquals(percentageOffer, bestOffer);
    }
}