package fr.kvaternik.adrien.bookstore.model.repository;

import android.support.annotation.NonNull;

import java.util.List;

import fr.kvaternik.adrien.bookstore.model.entity.Book;

/**
 * The fake book repository.
 */
public class FakeBookRepository implements BookRepository {
    @Override
    public void resetWithBooks(@NonNull List<Book> books) {
        // do nothing
    }

    @Override
    public void addBookToCart(String isbn) {
        // do nothing
    }

    @Override
    public void removeBookFromCart(String isbn) {
        // do nothing
    }
}
