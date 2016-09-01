package fr.kvaternik.adrien.bookstore.model.service.API;

import java.util.List;

import fr.kvaternik.adrien.bookstore.model.entity.Offer;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

/**
 * The offer API, used to fetch offers from the network.
 */
public interface OfferAPI {

    /**
     * Fetches the offer list
     * @param isbnPath the isbn path
     * @return The call.
     */
    @GET("books/{isbnPath}/commercialOffers")
    Call<List<Offer>> fetchOffers(@Path("isbnPath") String isbnPath);
}
