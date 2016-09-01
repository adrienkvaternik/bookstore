package fr.kvaternik.adrien.bookstore.model.service;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import java.util.List;

import fr.kvaternik.adrien.bookstore.model.entity.Offer;
import fr.kvaternik.adrien.bookstore.model.service.API.OfferAPI;
import fr.kvaternik.adrien.bookstore.model.service.API.provider.OfferAPIProvider;
import fr.kvaternik.adrien.bookstore.model.service.callback.Callback;
import fr.kvaternik.adrien.bookstore.utils.StringUtils;

/**
 * The service providing the offers.
 */
public class OfferService extends BaseService implements OfferServiceContract {

    private OfferAPIProvider mAPIProvider;

    @Override
    public void fetchOffers(@NonNull List<String> isbnList, @Nullable final Callback<List<Offer>> callback) {
        OfferAPI offerAPI = mAPIProvider.getOfferAPI();
        String isbnPath = StringUtils.join(isbnList, ",");
        enqueueCall(offerAPI.fetchOffers(isbnPath), callback);
    }

    public void setAPIProvider(OfferAPIProvider apiProvider) {
        mAPIProvider = apiProvider;
    }
}
