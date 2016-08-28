package fr.kvaternik.adrien.bookstore.model.service.API.provider;

import fr.kvaternik.adrien.bookstore.model.service.API.OfferAPI;

/**
 * The offer API provider.
 */
public interface OfferAPIProvider {

    /**
     * Provides the offer API.
     * @return A {@link OfferAPI}.
     */
    OfferAPI getOfferAPI();
}
