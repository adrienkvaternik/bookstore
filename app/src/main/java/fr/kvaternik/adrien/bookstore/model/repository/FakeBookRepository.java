package fr.kvaternik.adrien.bookstore.model.repository;

import java.util.ArrayList;
import java.util.List;

import fr.kvaternik.adrien.bookstore.model.entity.Book;

/**
 * A fake book repository.
 */
public class FakeBookRepository implements BookRepository {
    @Override
    public List<Book> getBooks() {
        ArrayList<Book> books = new ArrayList<>();
        books.add(new Book("", "Mon titre", 12, "http://henri-potier.xebia.fr/hp0.jpg"));
        books.add(new Book("", "Mon titre", 12, "http://henri-potier.xebia.fr/hp0.jpg"));
        books.add(new Book("", "Mon titre", 12, "http://henri-potier.xebia.fr/hp0.jpg"));
        books.add(new Book("", "Mon titre", 12, "http://henri-potier.xebia.fr/hp0.jpg"));

        return books;
    }
}
