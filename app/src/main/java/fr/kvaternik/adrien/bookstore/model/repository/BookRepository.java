package fr.kvaternik.adrien.bookstore.model.repository;

import java.util.List;

import fr.kvaternik.adrien.bookstore.model.entity.Book;

/**
 * The book repository.
 */
public interface BookRepository {

    /**
     * Provides the books.
     * @return A list of {@link Book}.
     */
    List<Book> getBooks();
}
