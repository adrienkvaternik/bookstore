package fr.kvaternik.adrien.bookstore.model.service;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import java.util.List;

import fr.kvaternik.adrien.bookstore.model.entity.Offer;

/**
 * The offer service contract.
 */
public interface OfferServiceContract {

    /**
     * Fetches the offers.
     * @param isbnList the isbn list of the books
     * @param callback the callback
     */
    void fetchOffers(@NonNull List<String> isbnList, @Nullable Callback callback);
    
    /**
     * The service callback.
     */
    interface Callback {
        /**
         * Called on success case.
         * @param offers the retrieved offers
         */
        void onSuccess(@NonNull List<Offer> offers);

        /**
         * Called on failure case.
         */
        void onFailure();
    }
}
