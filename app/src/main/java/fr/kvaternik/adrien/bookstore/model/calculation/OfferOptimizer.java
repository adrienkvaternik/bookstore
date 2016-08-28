package fr.kvaternik.adrien.bookstore.model.calculation;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import java.util.List;

import fr.kvaternik.adrien.bookstore.model.entity.Offer;

/**
 * The offer optimizer. Determines the best offer.
 */
public class OfferOptimizer implements OfferOptimizerContract {

    @Nullable
    @Override
    public Offer getBestOffer(@NonNull List<Offer> offers, double totalPrice) {
        Offer bestOffer = null;

        double minPrice = Double.MAX_VALUE;
        for (Offer offer : offers) {
            double reducedPrice = offer.getReducedPrice(totalPrice);
            if (minPrice > reducedPrice) {
                minPrice = reducedPrice;
                bestOffer = offer;
            }
        }

        return bestOffer;
    }
}
