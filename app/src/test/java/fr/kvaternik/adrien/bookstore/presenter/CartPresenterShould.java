package fr.kvaternik.adrien.bookstore.presenter;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Matchers;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.List;

import fr.kvaternik.adrien.bookstore.model.entity.Book;
import fr.kvaternik.adrien.bookstore.mvpcontract.CartMVP;
import fr.kvaternik.adrien.bookstore.presenter.VO.BookV0;
import fr.kvaternik.adrien.bookstore.presenter.VO.CartVO;

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
        List<BookV0> bookVOs = new ArrayList<>();
        bookVOs.add(new BookV0(firstIsbn, firstTitle, "35,00 €", firstCover));
        bookVOs.add(new BookV0(secondIsbn, secondTitle, "30,00 €", secondCover));

        // expected cart VO creation
        CartVO expectedCartVO = new CartVO(bookVOs, "65,00 €");

        // action
        mPresenter.presentCart(books, 65.0);

        // assertion
        verify(mMockView).updateCart(Matchers.eq(expectedCartVO));
    }

    @Test
    public void call_its_model_on_best_offer_request() throws Exception {
        // action
        mPresenter.requestBestOffer();

        // assertion
        verify(mMockModel).getBestOffer();
    }
}