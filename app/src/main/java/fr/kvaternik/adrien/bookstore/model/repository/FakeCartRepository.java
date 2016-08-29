package fr.kvaternik.adrien.bookstore.model.repository;

import java.util.ArrayList;
import java.util.List;

import fr.kvaternik.adrien.bookstore.model.entity.Book;

/**
 * A fake book repository.
 */
public class FakeCartRepository implements CartRepository {
    @Override
    public List<Book> getCartBooks() {
        ArrayList<Book> books = new ArrayList<>();
        books.add(new Book("c8fabf68-8374-48fe-a7ea-a00ccd07afff", "Mon titre", 12, "http://henri-potier.xebia.fr/hp0.jpg", false));
        books.add(new Book("a460afed-e5e7-4e39-a39d-c885c05db861", "Mon titre", 12, "http://henri-potier.xebia.fr/hp0.jpg", false));
        books.add(new Book("fcd1e6fa-a63f-4f75-9da4-b560020b6acc", "Mon titre", 12, "http://henri-potier.xebia.fr/hp0.jpg", false));
        books.add(new Book("c30968db-cb1d-442e-ad0f-80e37c077f89", "Mon titre", 12, "http://henri-potier.xebia.fr/hp0.jpg", false));

        return books;
    }
}
