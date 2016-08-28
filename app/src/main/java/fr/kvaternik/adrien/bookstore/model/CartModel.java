package fr.kvaternik.adrien.bookstore.model;

import fr.kvaternik.adrien.bookstore.mvpcontract.CartMVP;

/**
 * CThe model for the book list.
 */
public class CartModel implements CartMVP.ProvidedModelOperations {

    private CartMVP.RequiredPresenterOperations mPresenter;

    @Override
    public void attachPresenter(CartMVP.RequiredPresenterOperations presenter) {
        mPresenter = presenter;
    }
}
