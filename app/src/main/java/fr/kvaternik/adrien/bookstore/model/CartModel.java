package fr.kvaternik.adrien.bookstore.model;

import java.util.List;

import fr.kvaternik.adrien.bookstore.model.entity.Book;
import fr.kvaternik.adrien.bookstore.model.repository.BookRepository;
import fr.kvaternik.adrien.bookstore.mvpcontract.CartMVP;

/**
 * CThe model for the book list.
 */
public class CartModel implements CartMVP.ProvidedModelOperations {

    private CartMVP.RequiredPresenterOperations mPresenter;
    private BookRepository mRepository;

    @Override
    public void attachPresenter(CartMVP.RequiredPresenterOperations presenter) {
        mPresenter = presenter;
    }

    @Override
    public void getCart() {
        List<Book> books = mRepository.getBooks();

        double totalPrice = 0;
        for (Book book : books) {
            totalPrice += book.getPrice();
        }

        mPresenter.presentCart(books, totalPrice);
    }

    public void setRepository(BookRepository repository) {
        mRepository = repository;
    }
}
