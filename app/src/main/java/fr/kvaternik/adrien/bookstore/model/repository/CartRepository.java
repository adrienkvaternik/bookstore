package fr.kvaternik.adrien.bookstore.model.repository;

import android.support.annotation.NonNull;

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
    @NonNull
    List<Book> getCartBooks();
}
