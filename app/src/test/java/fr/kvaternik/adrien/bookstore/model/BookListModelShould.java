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
import fr.kvaternik.adrien.bookstore.model.service.callback.Callback;
import fr.kvaternik.adrien.bookstore.mvpcontract.BookListMVP;

import static org.mockito.Mockito.*;

/**
 * Tests for {@link BookListModel}.
 */
@SuppressWarnings("unchecked") // remove unchecked warnings due to invocations cast and Mockito.isA class parameter
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
        books.add(new Book("c8fabf68-8374-48fe-a7ea-a00ccd07afff", "Henri Potier à l'école des sorciers", 35.0, "http://henri-potier.xebia.fr/hp0.jpg"));
        books.add(new Book("a460afed-e5e7-4e39-a39d-c885c05db861", "Henri Potier et la Chambre des secrets", 30.0, "http://henri-potier.xebia.fr/hp1.jpg"));

        // stub service
        doAnswer(new Answer<Void>() {
            @Override
            public Void answer(InvocationOnMock invocation) throws Throwable {
                ((Callback<List<Book>>) invocation.getArguments()[0]).onSuccess(books);
                return null;
            }
        }).when(mMockService).fetchBooks(isA(Callback.class));

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
                ((Callback<List<Book>>) invocation.getArguments()[0]).onFailure();
                return null;
            }
        }).when(mMockService).fetchBooks(isA(Callback.class));

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

    @Test
    public void call_its_repository_on_book_removed_from_cart() throws Exception {
        // constants declaration
        final String isbn = "c8fabf68-8374-48fe-a7ea-a00ccd07afff";

        // action
        mModel.removeBookFromCart(isbn);

        // assertion
        verify(mMockRepository).removeBookFromCart(eq(isbn));
    }

    @Test
    public void send_no_book_to_its_presenter_and_reset_its_repository_when_no_book_fetched() throws Exception {
        // data preparation
        final List<Book> books = new ArrayList<>();

        // stub service
        doAnswer(new Answer<Void>() {
            @Override
            public Void answer(InvocationOnMock invocation) throws Throwable {
                ((Callback<List<Book>>) invocation.getArguments()[0]).onSuccess(books);
                return null;
            }
        }).when(mMockService).fetchBooks(isA(Callback.class));

        // action
        mModel.getBooks();

        // assertions
        verify(mMockRepository).resetWithBooks(eq(books));
        verify(mMockPresenter).presentNoBook();
    }
}