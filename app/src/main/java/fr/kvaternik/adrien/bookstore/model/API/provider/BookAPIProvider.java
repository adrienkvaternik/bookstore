package fr.kvaternik.adrien.bookstore.model.api.provider;

import fr.kvaternik.adrien.bookstore.model.api.BookAPI;

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
