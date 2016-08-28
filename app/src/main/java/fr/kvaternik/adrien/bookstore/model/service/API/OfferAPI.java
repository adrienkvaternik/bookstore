package fr.kvaternik.adrien.bookstore.model.service.API;

import java.util.List;

import fr.kvaternik.adrien.bookstore.model.entity.Offer;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Url;

/**
 * The offer API, used to fetch offers from the network.
 */
public interface OfferAPI {

    /**
     * Fetches the offer list
     * @param url the url
     * @return The call.
     */
    @GET
    Call<List<Offer>> fetchOffers(@Url String url);
}
