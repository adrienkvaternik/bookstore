package fr.kvaternik.adrien.bookstore.model.calculation;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import java.util.List;

import fr.kvaternik.adrien.bookstore.model.entity.MinusOffer;
import fr.kvaternik.adrien.bookstore.model.entity.Offer;

/**
 * A fake offer optimizer.
 */
public class FakeOfferOptimizer implements OfferOptimizerContract {
    @Nullable
    @Override
    public Offer getBestOffer(@NonNull List<Offer> offers, double totalPrice) {
        return new MinusOffer(20);
    }
}
