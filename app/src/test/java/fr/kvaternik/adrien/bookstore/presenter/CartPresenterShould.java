package fr.kvaternik.adrien.bookstore.presenter;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.List;

import fr.kvaternik.adrien.bookstore.model.entity.Book;
import fr.kvaternik.adrien.bookstore.model.entity.MinusOffer;
import fr.kvaternik.adrien.bookstore.model.entity.PercentageOffer;
import fr.kvaternik.adrien.bookstore.mvpcontract.CartMVP;
import fr.kvaternik.adrien.bookstore.presenter.VO.BookVO;
import fr.kvaternik.adrien.bookstore.presenter.VO.CartVO;
import fr.kvaternik.adrien.bookstore.presenter.VO.OfferVO;

import static org.mockito.Mockito.*;

/**
 * Tests for {@link BookListPresenter}.
 */
@RunWith(MockitoJUnitRunner.class)
public class CartPresenterShould {

    private CartPresenter mPresenter;

    @Mock
    private CartMVP.ProvidedModelOperations mMockModel;

    @Mock
    private CartMVP.RequiredViewOperations mMockView;

    @Before
    public void setUp() throws Exception {
        mPresenter = new CartPresenter();
        mPresenter.attachModel(mMockModel);
        mPresenter.attachView(mMockView);
    }

    @Test
    public void call_its_model_on_cart_request() throws Exception {
        // action
        mPresenter.requestCart();

        // assertion
        verify(mMockModel).getCart();
    }

    @Test
    public void call_its_view_on_cart_presentation() throws Exception {
        // constants declaration
        final String firstIsbn = "c8fabf68-8374-48fe-a7ea-a00ccd07afff";
        final String firstTitle = "Henri Potier à l'école des sorciers";
        final String firstCover = "http://henri-potier.xebia.fr/hp0.jpg";
        final String secondIsbn = "a460afed-e5e7-4e39-a39d-c885c05db861";
        final String secondTitle = "Henri Potier et la Chambre des secrets";
        final String secondCover = "http://henri-potier.xebia.fr/hp1.jpg";

        // book list creation
        List<Book> books = new ArrayList<>();
        books.add(new Book(firstIsbn, firstTitle, 35.0, firstCover));
        books.add(new Book(secondIsbn, secondTitle, 30.0, secondCover));

        // book VOs list creation
        List<BookVO> bookVOs = new ArrayList<>();
        bookVOs.add(new BookVO(firstIsbn, firstTitle, "35,00 €", firstCover, true));
        bookVOs.add(new BookVO(secondIsbn, secondTitle, "30,00 €", secondCover, true));

        // expected cart VO creation
        CartVO expectedCartVO = new CartVO(bookVOs, "65,00 €");

        // action
        mPresenter.presentCart(books, 65.0);

        // assertion
        verify(mMockView).showCart(eq(expectedCartVO));
    }

    @Test
    public void call_its_view_on_no_offer_presentation() throws Exception {
        // action
        mPresenter.presentNoOffer();

        // assertion
        verify(mMockView).showNoOffer();
    }

    @Test
    public void call_its_view_on_error_presentation() throws Exception {
        // action
        mPresenter.presentOfferError();

        // assertion
        verify(mMockView).showError();
    }

    @Test
    public void call_its_model_on_best_offer_request() throws Exception {
        // action
        mPresenter.requestBestOffer();

        // assertion
        verify(mMockModel).getBestOffer();
    }

    @Test
    public void call_its_view_on_offer_euros_presentation() throws Exception {
        // offer VO creation
        OfferVO expectedOfferVO = new OfferVO("-20,00 €", "80,00 €");

        // action
        mPresenter.presentBestOffer(new MinusOffer(20), 80.0);

        // assertion
        verify(mMockView).showOffer(expectedOfferVO);
    }

    @Test
    public void call_its_view_on_offer_percent_presentation() throws Exception {
        // offer VO creation
        OfferVO expectedOfferVO = new OfferVO("-20,00 %", "80,00 €");

        // action
        mPresenter.presentBestOffer(new PercentageOffer(20), 80.0);

        // assertion
        verify(mMockView).showOffer(expectedOfferVO);
    }
}