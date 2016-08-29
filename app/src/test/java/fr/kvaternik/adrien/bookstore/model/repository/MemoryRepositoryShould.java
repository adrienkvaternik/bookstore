package fr.kvaternik.adrien.bookstore.model.repository;

import org.junit.Test;

import java.util.ArrayList;

import fr.kvaternik.adrien.bookstore.model.entity.Book;

import static org.junit.Assert.*;

/**
 * Tests for {@link MemoryRepository}.
 */
public class MemoryRepositoryShould {

    @Test
    public void should_initially_return_an_empty_cart() throws Exception {
        // action
        MemoryRepository repository = MemoryRepository.getInstance();
        // assertion
        assertTrue(repository.getCartBooks().isEmpty());
    }

    @Test
    public void should_store_books_in_cart() throws Exception {
        // data preparation
        String firstIsbn = "c8fabf68-8374-48fe-a7ea-a00ccd07afff";
        String secondIsbn = "a460afed-e5e7-4e39-a39d-c885c05db861";
        Book firstBook = new Book(firstIsbn, "Mon titre", 12, "http://henri-potier.xebia.fr/hp0.jpg");
        Book secondBook = new Book(secondIsbn, "Mon titre", 12, "http://henri-potier.xebia.fr/hp0.jpg");
        ArrayList<Book> books = new ArrayList<>();
        books.add(firstBook);
        books.add(secondBook);

        ///// BOOKS NOT IN CART UNTIL ADDED /////

        // actions
        MemoryRepository repository = MemoryRepository.getInstance();
        repository.resetWithBooks(books);
        // assertion
        assertTrue(repository.getCartBooks().isEmpty());


        ///// BOOKS CORRECTLY ADDED /////

        // actions
        repository.addBookToCart(firstIsbn);
        repository.addBookToCart(secondIsbn);
        // assertion
        assertArrayEquals(new Book[]{firstBook, secondBook}, repository.getCartBooks().toArray());


        ///// BOOKS CORRECTLY REMOVED /////

        // actions
        repository.removeBookFromCart(firstIsbn);
        // assertion
        assertArrayEquals(new Book[]{secondBook}, repository.getCartBooks().toArray());


        ///// EMPTY CART WHEN RESET /////

        // actions
        repository.resetWithBooks(books);
        // assertion
        assertTrue(repository.getCartBooks().isEmpty());
    }
}