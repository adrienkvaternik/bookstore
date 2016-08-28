package fr.kvaternik.adrien.bookstore.model.repository;

import java.util.List;

import fr.kvaternik.adrien.bookstore.model.entity.Book;

/**
 * The cart repository.
 */
public interface CartRepository {

    /**
     * Provides the books in the cart.
     * @return A list of {@link Book}.
     */
    List<Book> getCartBooks();
}
