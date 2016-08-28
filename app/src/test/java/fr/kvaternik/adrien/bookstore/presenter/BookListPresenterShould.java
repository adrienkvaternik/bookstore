package fr.kvaternik.adrien.bookstore.presenter;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.List;

import fr.kvaternik.adrien.bookstore.model.entity.Book;
import fr.kvaternik.adrien.bookstore.mvpcontract.BookListMVP;
import fr.kvaternik.adrien.bookstore.presenter.VO.BookVO;

import static org.mockito.Mockito.*;

/**
 * Tests for {@link BookListPresenter}.
 */
@RunWith(MockitoJUnitRunner.class)
public class BookListPresenterShould {

    private BookListPresenter mPresenter;

    @Mock
    private BookListMVP.ProvidedModelOperations mMockModel;

    @Mock
    private BookListMVP.RequiredViewOperations mMockView;

    @Before
    public void setUp() throws Exception {
        mPresenter = new BookListPresenter();
        mPresenter.attachModel(mMockModel);
        mPresenter.attachView(mMockView);
    }

    @Test
    public void call_its_model_on_book_request() throws Exception {
        // action
        mPresenter.requestBooks();

        // assertion
        verify(mMockModel).getBooks();
    }

    @Test
    public void call_its_view_on_book_presentation() throws Exception {
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

        // expected book VOs list creation
        List<BookVO> expectedBookVOs = new ArrayList<>();
        expectedBookVOs.add(new BookVO(firstIsbn, firstTitle, "35,00 €", firstCover));
        expectedBookVOs.add(new BookVO(secondIsbn, secondTitle, "30,00 €", secondCover));

        // action
        mPresenter.presentBooks(books);

        // assertion
        verify(mMockView).updateBookList(eq(expectedBookVOs));
    }
}