package fr.kvaternik.adrien.bookstore.model;

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
        mPresenter.presentCart(mRepository.getBooks());
    }

    public void setRepository(BookRepository repository) {
        mRepository = repository;
    }
}
