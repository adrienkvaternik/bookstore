package fr.kvaternik.adrien.bookstore.model.service;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import java.util.List;

import fr.kvaternik.adrien.bookstore.model.entity.Book;

/**
 * The book service contract.
 */
public interface BookServiceContract {

    /**
     * Fetches the books.
     * @param callback the callback
     */
    void fetchBooks(@Nullable Callback callback);

    /**
     * The service callback.
     */
    interface Callback {
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
