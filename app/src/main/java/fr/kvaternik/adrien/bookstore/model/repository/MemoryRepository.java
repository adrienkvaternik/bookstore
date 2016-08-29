package fr.kvaternik.adrien.bookstore.model.repository;

import android.support.annotation.NonNull;

import java.util.ArrayList;
import java.util.List;

import fr.kvaternik.adrien.bookstore.model.entity.Book;

/**
 * The memory repository. Keeps the books, can add/remove them from the cart and provides the cart.
 */
public class MemoryRepository implements BookRepository, CartRepository {

    // private constructor to prevent external instantiation of singleton
    private MemoryRepository() {}

    @Override
    public void resetWithBooks(@NonNull List<Book> books) {
        // TODO : impl
    }

    @Override
    public void addBookToCart(String isbn) {
        // TODO : impl
    }

    @Override
    public void removeBookFromCart(String isbn) {
        // TODO : impl
    }

    @NonNull
    @Override
    public List<Book> getCartBooks() {
        // TODO : impl
        return new ArrayList<>();
    }

    /**
     * Provides the unique {@link MemoryRepository} instance.
     * @return The unique {@link MemoryRepository} instance.
     */
    @NonNull
    public static MemoryRepository getInstance() {
        return Holder.INSTANCE;
    }

    /**
     * The memory repository holder.
     */
    private static final class Holder {
        static final MemoryRepository INSTANCE = new MemoryRepository();

        private Holder() {}
    }
}
