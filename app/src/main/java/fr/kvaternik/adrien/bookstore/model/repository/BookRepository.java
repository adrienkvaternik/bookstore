package fr.kvaternik.adrien.bookstore.model.repository;

import android.support.annotation.NonNull;

import java.util.List;

import fr.kvaternik.adrien.bookstore.model.entity.Book;

/**
 * The book repository.
 */
public interface BookRepository {

    /**
     * Resets the repository with the specified books.
     * @param books the books
     */
    void resetWithBooks(@NonNull List<Book> books);

    /**
     * Adds the book to the cart.
     * @param isbn the book isbn
     */
    void addBookToCart(String isbn);
}
