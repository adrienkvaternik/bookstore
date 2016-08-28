package fr.kvaternik.adrien.bookstore.model;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Matchers;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.List;

import fr.kvaternik.adrien.bookstore.model.entity.Book;
import fr.kvaternik.adrien.bookstore.model.repository.BookRepository;
import fr.kvaternik.adrien.bookstore.mvpcontract.CartMVP;

import static org.mockito.Mockito.*;

/**
 * Tests for {@link CartModel}.
 */
@RunWith(MockitoJUnitRunner.class)
public class CartModelShould {

    private CartModel mModel;

    @Mock
    private CartMVP.RequiredPresenterOperations mMockPresenter;

    @Mock
    private BookRepository mMockRepository;

    @Before
    public void setUp() throws Exception {
        mModel = new CartModel();
        mModel.attachPresenter(mMockPresenter);
        mModel.setRepository(mMockRepository);
    }

    @Test
    public void send_its_repository_books_to_its_presenter() throws Exception {
        // data preparation
        final List<Book> books = new ArrayList<>();
        books.add(new Book("c8fabf68-8374-48fe-a7ea-a00ccd07afff", "Henri Potier à l'école des sorciers", 35.0, "http://henri-potier.xebia.fr/hp0.jpg"));
        books.add(new Book("a460afed-e5e7-4e39-a39d-c885c05db861", "Henri Potier et la Chambre des secrets", 30.0, "http://henri-potier.xebia.fr/hp1.jpg"));

        // stub repository
        when(mMockRepository.getBooks()).thenReturn(books);

        // action
        mModel.getCart();

        // assertion
        verify(mMockPresenter).presentCart(Matchers.eq(books), Matchers.eq(65.0));
    }
}