package fr.kvaternik.adrien.bookstore.presenter;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import fr.kvaternik.adrien.bookstore.mvpcontract.BookListMVP;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

/**
 * Tests for {@link BookListPresenter}.
 */
@RunWith(MockitoJUnitRunner.class)
public class BookListPresenterShould {

    private BookListPresenter mPresenter;

    @Mock
    private BookListMVP.ProvidedModelOperations mMockModel;

    @Before
    public void setUp() throws Exception {
        mPresenter = new BookListPresenter();
        mPresenter.attachModel(mMockModel);
    }

    @Test
    public void call_its_model_on_book_request() throws Exception {
        mPresenter.requestBooks();
        verify(mMockModel).getBooks();
    }
}