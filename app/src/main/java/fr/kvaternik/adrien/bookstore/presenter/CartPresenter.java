package fr.kvaternik.adrien.bookstore.presenter;

import android.support.annotation.NonNull;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

import fr.kvaternik.adrien.bookstore.model.entity.Book;
import fr.kvaternik.adrien.bookstore.model.entity.Offer;
import fr.kvaternik.adrien.bookstore.model.mapper.BookToBookVOMapper;
import fr.kvaternik.adrien.bookstore.mvpcontract.CartMVP;
import fr.kvaternik.adrien.bookstore.presenter.VO.BookVO;
import fr.kvaternik.adrien.bookstore.presenter.VO.CartVO;
import fr.kvaternik.adrien.bookstore.presenter.VO.OfferVO;
import fr.kvaternik.adrien.bookstore.utils.DecimalFormatUtils;

/**
 * The presenter for the cart.
 */
public class CartPresenter extends BasePresenter<CartMVP.RequiredViewOperations, CartMVP.ProvidedModelOperations> implements CartMVP.ProvidedPresenterOperations, CartMVP.RequiredPresenterOperations {

    /** Decimal formatter with 2 decimals, in euros */
    private DecimalFormat mDecimalFormatEuros = DecimalFormatUtils.decimalFormatEuros();
    /** Decimal formatter with 2 decimals, in euros reduction */
    private DecimalFormat mDecimalFormatEurosReduction = DecimalFormatUtils.decimalFormatEurosReduction();
    /** Decimal formatter with 2 decimals, in percent reduction */
    private DecimalFormat mDecimalFormatPercentReduction = DecimalFormatUtils.decimalFormatPercentReduction();

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
        BookToBookVOMapper mapper = new BookToBookVOMapper(mDecimalFormatEuros, true);

        List<BookVO> bookVOs = new ArrayList<>();
        for (Book book : books) {
            bookVOs.add(mapper.map(book));
        }

        mView.showCart(new CartVO(bookVOs, mDecimalFormatEuros.format(totalPrice)));
    }

    @Override
    public void presentEmptyCart() {
        mView.showEmptyCart();
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

        mView.showOffer(new OfferVO(decimalFormat.format(bestOffer.getValue() * multiplier), mDecimalFormatEuros.format(reducedPrice)));
    }

    @Override
    public void presentNoOffer() {
        mView.showNoOffer();
    }

    @Override
    public void presentOfferError() {
        mView.showError();
    }
}
