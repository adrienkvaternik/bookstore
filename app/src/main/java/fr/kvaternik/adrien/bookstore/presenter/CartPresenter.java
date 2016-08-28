package fr.kvaternik.adrien.bookstore.presenter;

import android.support.annotation.NonNull;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

import fr.kvaternik.adrien.bookstore.model.entity.Book;
import fr.kvaternik.adrien.bookstore.model.entity.Offer;
import fr.kvaternik.adrien.bookstore.mvpcontract.CartMVP;
import fr.kvaternik.adrien.bookstore.presenter.VO.BookVO;
import fr.kvaternik.adrien.bookstore.presenter.VO.CartVO;
import fr.kvaternik.adrien.bookstore.presenter.VO.OfferVO;
import fr.kvaternik.adrien.bookstore.utils.DecimalFormatUtils;

/**
 * The presenter for the cart.
 */
public class CartPresenter implements CartMVP.ProvidedPresenterOperations, CartMVP.RequiredPresenterOperations {

    /** Decimal formatter with 2 decimals, in euros */
    private DecimalFormat mDecimalFormatEuros = DecimalFormatUtils.decimalFormatEuros();
    /** Decimal formatter with 2 decimals, in euros reduction */
    private DecimalFormat mDecimalFormatEurosReduction = DecimalFormatUtils.decimalFormatEurosReduction();
    /** Decimal formatter with 2 decimals, in percent reduction */
    private DecimalFormat mDecimalFormatPercentReduction = DecimalFormatUtils.decimalFormatPercentReduction();

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
        List<BookVO> bookVOs = new ArrayList<>();
        for (Book book : books) {
            bookVOs.add(convertBookToBookVO(book));
        }

        mView.updateCart(new CartVO(bookVOs, mDecimalFormatEuros.format(totalPrice)));
    }

    @Override
    public void presentBestOffer(@NonNull Offer bestOffer, double reducedPrice) {
        int offerUnit = bestOffer.getUnit();

        DecimalFormat decimalFormat;
        double multiplier;
        switch (offerUnit) {
            case Offer.UNIT_EUROS:
                decimalFormat = mDecimalFormatEurosReduction;
                multiplier = 1.0;
                break;
            case Offer.UNIT_PERCENT:
                decimalFormat = mDecimalFormatPercentReduction;
                multiplier = 1.0 / 100.0;
                break;
            default:
                throw new IllegalStateException("Unknown offer unit : " + offerUnit);
        }

        mView.updateOffer(new OfferVO(decimalFormat.format(bestOffer.getValue() * multiplier), mDecimalFormatEuros.format(reducedPrice)));
    }

    @Override
    public void presentNoOffer() {
        // TODO : impl
    }

    @Override
    public void presentOfferError() {
        // TODO : impl
    }

    /**
     * Converts a {@link Book} into a {@link BookVO}.
     * @param book the book to convert.
     * @return The resulting {@link BookVO}.
     */
    @NonNull
    private BookVO convertBookToBookVO(@NonNull Book book) {
        return new BookVO(
                book.getIsbn(),
                book.getTitle(),
                mDecimalFormatEuros.format(book.getPrice()),
                book.getCover()
        );
    }
}
