package fr.kvaternik.adrien.bookstore.model.service.API.provider;

import fr.kvaternik.adrien.bookstore.model.service.API.BookAPI;

/**
 * The book API provider.
 */
public interface BookAPIProvider {

    /**
     * Provides the book API.
     * @return A {@link BookAPI}.
     */
    BookAPI getBookAPI();
}
