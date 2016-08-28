package fr.kvaternik.adrien.bookstore.presenter;

import android.support.annotation.NonNull;

import java.util.List;

import fr.kvaternik.adrien.bookstore.model.entity.Book;
import fr.kvaternik.adrien.bookstore.mvpcontract.CartMVP;

/**
 * The presenter for the cart.
 */
public class CartPresenter implements CartMVP.ProvidedPresenterOperations, CartMVP.RequiredPresenterOperations {

    private CartMVP.RequiredViewOperations mView;
    private CartMVP.ProvidedModelOperations mModel;

    @Override
    public void attachView(CartMVP.RequiredViewOperations view) {
        mView = view;
    }

    @Override
    public void detachView() {
        mView = null;
    }

    @Override
    public void attachModel(CartMVP.ProvidedModelOperations model) {
        mModel = model;
    }

    @Override
    public void detachModel() {
        mModel = null;
    }

    @Override
    public void requestCart() {
        mModel.getCart();
    }

    @Override
    public void presentCart(@NonNull List<Book> books) {
        // TODO : impl
    }
}
