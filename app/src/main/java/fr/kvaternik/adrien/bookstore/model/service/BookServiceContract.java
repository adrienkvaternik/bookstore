package fr.kvaternik.adrien.bookstore.model.service;

import android.support.annotation.Nullable;

import java.util.List;

import fr.kvaternik.adrien.bookstore.model.entity.Book;
import fr.kvaternik.adrien.bookstore.model.service.callback.Callback;

/**
 * The book service contract.
 */
public interface BookServiceContract {

    /**
     * Fetches the books.
     * @param callback the callback
     */
    void fetchBooks(@Nullable Callback<List<Book>> callback);
}
