package fr.kvaternik.adrien.bookstore.model.repository;

import android.support.annotation.NonNull;

import java.util.ArrayList;
import java.util.List;

import fr.kvaternik.adrien.bookstore.model.entity.Book;

/**
 * The memory repository. Keeps the books, can add/remove them from the cart and provides the cart.
 */
public class MemoryRepository implements BookRepository, CartRepository {

    private List<Book> mBooks = new ArrayList<>();
    private List<Book> mCart = new ArrayList<>();

    // private constructor to prevent external instantiation of singleton
    private MemoryRepository() {}

    @Override
    public void resetWithBooks(@NonNull List<Book> books) {
        mBooks = books;
        mCart.clear();
    }

    @Override
    public void addBookToCart(String isbn) {
        for (Book book : mBooks) {
            if (isbn.equals(book.getIsbn())) {
                mCart.add(book);
                break;
            }
        }
    }

    @Override
    public void removeBookFromCart(String isbn) {
        for (Book book : mCart) {
            if (isbn.equals(book.getIsbn())) {
                mCart.remove(book);
                break;
            }
        }
    }

    @NonNull
    @Override
    public List<Book> getCartBooks() {
        return mCart;
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
