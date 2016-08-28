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

import fr.kvaternik.adrien.bookstore.model.calculation.OfferOptimizerContract;
import fr.kvaternik.adrien.bookstore.model.entity.Book;
import fr.kvaternik.adrien.bookstore.model.entity.MinusOffer;
import fr.kvaternik.adrien.bookstore.model.entity.Offer;
import fr.kvaternik.adrien.bookstore.model.repository.CartRepository;
import fr.kvaternik.adrien.bookstore.model.service.OfferServiceContract;
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
    private CartRepository mMockRepository;

    @Mock
    private OfferOptimizerContract mMockOfferOptimizer;

    @Mock
    private OfferServiceContract mMockService;

    @Before
    public void setUp() throws Exception {
        mModel = new CartModel();
        mModel.attachPresenter(mMockPresenter);
        mModel.setRepository(mMockRepository);
        mModel.setOfferOptimizer(mMockOfferOptimizer);
        mModel.setService(mMockService);
    }

    @Test
    public void send_its_repository_books_to_its_presenter() throws Exception {
        // data preparation
        final List<Book> books = new ArrayList<>();
        books.add(new Book("c8fabf68-8374-48fe-a7ea-a00ccd07afff", "Henri Potier à l'école des sorciers", 35.0, "http://henri-potier.xebia.fr/hp0.jpg"));
        books.add(new Book("a460afed-e5e7-4e39-a39d-c885c05db861", "Henri Potier et la Chambre des secrets", 30.0, "http://henri-potier.xebia.fr/hp1.jpg"));

        // stub repository
        when(mMockRepository.getCartBooks()).thenReturn(books);

        // action
        mModel.getCart();

        // assertion
        verify(mMockPresenter).presentCart(eq(books), eq(65.0));
    }

    @Test
    public void send_the_best_offer_to_its_presenter_on_fetch_success() throws Exception {
        // books preparation
        List<Book> books = new ArrayList<>();
        books.add(new Book("c8fabf68-8374-48fe-a7ea-a00ccd07afff", "Henri Potier à l'école des sorciers", 35.0, "http://henri-potier.xebia.fr/hp0.jpg"));
        books.add(new Book("a460afed-e5e7-4e39-a39d-c885c05db861", "Henri Potier et la Chambre des secrets", 30.0, "http://henri-potier.xebia.fr/hp1.jpg"));

        // stub repository
        when(mMockRepository.getCartBooks()).thenReturn(books);

        // offers preparation
        final List<Offer> offers = new ArrayList<>();
        Offer bestOffer = new MinusOffer(20);
        offers.add(bestOffer);

        // stub offer optimizer
        when(mMockOfferOptimizer.getBestOffer(anyListOf(Offer.class), anyDouble())).thenReturn(bestOffer);

        // stub service
        doAnswer(new Answer<Void>() {
            @Override
            public Void answer(InvocationOnMock invocation) throws Throwable {
                ((OfferServiceContract.Callback) invocation.getArguments()[0]).onSuccess(offers);
                return null;
            }
        }).when(mMockService).fetchOffers(isA(OfferServiceContract.Callback.class));

        // action
        mModel.getBestOffer();

        // assertion
        verify(mMockPresenter).presentBestOffer(eq(bestOffer), eq(45.0));
    }

    @Test
    public void send_no_offer_to_its_presenter_when_no_offer_fetched() throws Exception {
        // data preparation
        final List<Offer> offers = new ArrayList<>();

        // stub offer optimizer
        when(mMockOfferOptimizer.getBestOffer(anyListOf(Offer.class), anyDouble())).thenReturn(null);

        // stub service
        doAnswer(new Answer<Void>() {
            @Override
            public Void answer(InvocationOnMock invocation) throws Throwable {
                ((OfferServiceContract.Callback) invocation.getArguments()[0]).onSuccess(offers);
                return null;
            }
        }).when(mMockService).fetchOffers(isA(OfferServiceContract.Callback.class));

        // action
        mModel.getBestOffer();

        // assertion
        verify(mMockPresenter).presentNoOffer();
    }
}