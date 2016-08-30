package fr.kvaternik.adrien.bookstore.model.service;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;

import fr.kvaternik.adrien.bookstore.model.entity.Offer;
import fr.kvaternik.adrien.bookstore.model.service.API.OfferAPI;
import fr.kvaternik.adrien.bookstore.model.service.API.provider.OfferAPIProvider;
import fr.kvaternik.adrien.bookstore.model.service.callback.Callback;
import fr.kvaternik.adrien.bookstore.utils.StringUtils;
import retrofit2.Call;
import retrofit2.Response;

/**
 * The service providing the offers.
 */
public class OfferService extends BaseService implements OfferServiceContract {

    private OfferAPIProvider mAPIProvider;

    @Override
    public void fetchOffers(@NonNull List<String> isbnList, @Nullable final Callback<List<Offer>> callback) {
        OfferAPI offerAPI = mAPIProvider.getOfferAPI();
        String url = getFetchOffersUrlFromIsbnList(isbnList);
        enqueueCall(offerAPI.fetchOffers(url), callback);
    }

    public void setAPIProvider(OfferAPIProvider apiProvider) {
        mAPIProvider = apiProvider;
    }

    /**
     * Provides the fetch offers url from the specified isbn list.
     * @param isbnList the isbn list
     * @return The fetch offers url.
     */
    @NonNull
    private String getFetchOffersUrlFromIsbnList(@NonNull List<String> isbnList) {
        String isbnComponent = StringUtils.join(isbnList, ",");

        List<String> urlComponents = new ArrayList<>();
        urlComponents.add("books");
        urlComponents.add(isbnComponent);
        urlComponents.add("commercialOffers");

        return StringUtils.join(urlComponents, "/");
    }
}
