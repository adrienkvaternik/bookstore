package fr.kvaternik.adrien.bookstore.model;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.runners.MockitoJUnitRunner;
import org.mockito.stubbing.Answer;

import java.util.ArrayList;
import java.util.List;

import fr.kvaternik.adrien.bookstore.model.entity.Book;
import fr.kvaternik.adrien.bookstore.model.repository.BookRepository;
import fr.kvaternik.adrien.bookstore.model.service.BookServiceContract;
import fr.kvaternik.adrien.bookstore.mvpcontract.BookListMVP;

import static org.mockito.Mockito.*;

/**
 * Tests for {@link BookListModel}.
 */
@RunWith(MockitoJUnitRunner.class)
public class BookListModelShould {

    private BookListModel mModel;

    @Mock
    private BookListMVP.RequiredPresenterOperations mMockPresenter;

    @Mock
    private BookServiceContract mMockService;

    @Mock
    private BookRepository mMockRepository;

    @Before
    public void setUp() throws Exception {
        mModel = new BookListModel();
        mModel.attachPresenter(mMockPresenter);
        mModel.setService(mMockService);
        mModel.setRepository(mMockRepository);
    }

    @Test
    public void send_books_to_its_presenter_and_reset_its_repository_on_fetch_success() throws Exception {
        // data preparation
        final List<Book> books = new ArrayList<>();
        books.add(new Book("c8fabf68-8374-48fe-a7ea-a00ccd07afff", "Henri Potier à l'école des sorciers", 35.0, "http://henri-potier.xebia.fr/hp0.jpg", false));
        books.add(new Book("a460afed-e5e7-4e39-a39d-c885c05db861", "Henri Potier et la Chambre des secrets", 30.0, "http://henri-potier.xebia.fr/hp1.jpg", false));

        // stub service
        doAnswer(new Answer<Void>() {
            @Override
            public Void answer(InvocationOnMock invocation) throws Throwable {
                ((BookServiceContract.Callback) invocation.getArguments()[0]).onSuccess(books);
                return null;
            }
        }).when(mMockService).fetchBooks(isA(BookServiceContract.Callback.class));

        // action
        mModel.getBooks();

        // assertions
        verify(mMockRepository).resetWithBooks(eq(books));
        verify(mMockPresenter).presentBooks(eq(books));
    }

    @Test
    public void notify_error_to_its_presenter_on_fetch_failure() throws Exception {
        // stub service
        doAnswer(new Answer<Void>() {
            @Override
            public Void answer(InvocationOnMock invocation) throws Throwable {
                ((BookServiceContract.Callback) invocation.getArguments()[0]).onFailure();
                return null;
            }
        }).when(mMockService).fetchBooks(isA(BookServiceContract.Callback.class));

        // action
        mModel.getBooks();

        // assertion
        verify(mMockPresenter).presentError();
    }

    @Test
    public void call_its_repository_on_book_added_to_cart() throws Exception {
        // constants declaration
        final String isbn = "c8fabf68-8374-48fe-a7ea-a00ccd07afff";

        // action
        mModel.addBookToCart(isbn);

        // assertion
        verify(mMockRepository).addBookToCart(eq(isbn));
    }
}