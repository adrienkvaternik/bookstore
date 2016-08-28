package fr.kvaternik.adrien.bookstore.model.calculation;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import java.util.List;

import fr.kvaternik.adrien.bookstore.model.entity.Offer;

/**
 * The contract for an offer optimizer.
 */
public interface OfferOptimizerContract {

    /**
     * Provides the best offer among the specified ones. If the list of offers is empty, should return <code>null</code>.
     * @param offers the list of offers
     * @param totalPrice the total price on which the offer is applied
     * @return The best offer, or null if no offer.
     */
    @Nullable
    Offer getBestOffer(@NonNull List<Offer> offers, double totalPrice);
}
