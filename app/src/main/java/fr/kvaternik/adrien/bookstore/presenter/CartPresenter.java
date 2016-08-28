package fr.kvaternik.adrien.bookstore.presenter;

import android.support.annotation.NonNull;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

import fr.kvaternik.adrien.bookstore.model.entity.Book;
import fr.kvaternik.adrien.bookstore.model.entity.Offer;
import fr.kvaternik.adrien.bookstore.mvpcontract.CartMVP;
import fr.kvaternik.adrien.bookstore.presenter.VO.BookV0;
import fr.kvaternik.adrien.bookstore.presenter.VO.CartVO;
import fr.kvaternik.adrien.bookstore.utils.DecimalFormatUtils;

/**
 * The presenter for the cart.
 */
public class CartPresenter implements CartMVP.ProvidedPresenterOperations, CartMVP.RequiredPresenterOperations {

    /** Decimal formatter with 2 decimals, in euros, used to convert a {@link Book} into a {@link BookV0}, see method {@link #convertBookToBookVO(Book)} */
    private DecimalFormat mDecimalFormat = DecimalFormatUtils.decimalFormatEuros();

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
    public void requestBestOffer() {
        mModel.getBestOffer();
    }

    @Override
    public void presentCart(@NonNull List<Book> books, double totalPrice) {
        List<BookV0> bookV0s = new ArrayList<>();
        for (Book book : books) {
            bookV0s.add(convertBookToBookVO(book));
        }

        mView.updateCart(new CartVO(bookV0s, mDecimalFormat.format(totalPrice)));
    }

    @Override
    public void presentBestOffer(@NonNull Offer bestOffer) {
        // TODO : impl
    }

    /**
     * Converts a {@link Book} into a {@link BookV0}.
     * @param book the book to convert.
     * @return The resulting {@link BookV0}.
     */
    @NonNull
    private BookV0 convertBookToBookVO(@NonNull Book book) {
        return new BookV0(
                book.getIsbn(),
                book.getTitle(),
                mDecimalFormat.format(book.getPrice()),
                book.getCover()
        );
    }
}
