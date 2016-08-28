package fr.kvaternik.adrien.bookstore.model.service;

import android.support.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;

import fr.kvaternik.adrien.bookstore.model.entity.MinusOffer;
import fr.kvaternik.adrien.bookstore.model.entity.Offer;

/**
 * The fake offer service.
 */
public class FakeOfferService implements OfferServiceContract {
    @Override
    public void fetchOffers(@Nullable Callback callback) {
        final List<Offer> offers = new ArrayList<>();
        Offer bestOffer = new MinusOffer(20);
        offers.add(bestOffer);

        if (callback != null) {
            callback.onSuccess(offers);
        }
    }
}
