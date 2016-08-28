package fr.kvaternik.adrien.bookstore.model.service;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import java.util.List;

import fr.kvaternik.adrien.bookstore.model.entity.Book;

/**
 * The service providing the books.
 */
public class BookService {

    /**
     * Fetches the books.
     * @param callback the callback
     */
    public void fetchBooks(@Nullable Callback callback) {
        // TODO : impl
    }

    /**
     * The service callback.
     */
    public interface Callback {
        /**
         * Called on success case.
         * @param books the retrieved books
         */
        void onSuccess(@NonNull List<Book> books);

        /**
         * Called on failure case.
         */
        void onFailure();
    }
}
