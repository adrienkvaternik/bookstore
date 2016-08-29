package fr.kvaternik.adrien.bookstore.model.repository;

import android.support.annotation.NonNull;

import java.util.List;

import fr.kvaternik.adrien.bookstore.model.entity.Book;

/**
 * The book repository.
 */
public interface BookRepository {

    /**
     * Saves the books in the repository.
     * @param books the books to save
     */
    void saveBooks(@NonNull List<Book> books);
}
