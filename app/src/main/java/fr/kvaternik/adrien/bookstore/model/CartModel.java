package fr.kvaternik.adrien.bookstore.model;

import android.support.annotation.NonNull;

import java.util.ArrayList;
import java.util.List;

import fr.kvaternik.adrien.bookstore.model.calculation.OfferOptimizerContract;
import fr.kvaternik.adrien.bookstore.model.entity.Book;
import fr.kvaternik.adrien.bookstore.model.entity.Offer;
import fr.kvaternik.adrien.bookstore.model.repository.CartRepository;
import fr.kvaternik.adrien.bookstore.model.service.OfferServiceContract;
import fr.kvaternik.adrien.bookstore.mvpcontract.CartMVP;

/**
 * CThe model for the book list.
 */
public class CartModel implements CartMVP.ProvidedModelOperations {

    private CartMVP.RequiredPresenterOperations mPresenter;
    private CartRepository mRepository;
    private OfferServiceContract mService;
    private OfferOptimizerContract mOfferOptimizer;

    public void setRepository(CartRepository repository) {
        mRepository = repository;
    }

    public void setService(OfferServiceContract service) {
        mService = service;
    }

    public void setOfferOptimizer(OfferOptimizerContract offerOptimizer) {
        mOfferOptimizer = offerOptimizer;
    }

    @Override
    public void attachPresenter(CartMVP.RequiredPresenterOperations presenter) {
        mPresenter = presenter;
    }

    @Override
    public void getCart() {
        List<Book> books = getBooksInCartFromRepository();
        double totalPrice = getTotalPriceForBooks(books);
        mPresenter.presentCart(books, totalPrice);
    }

    @Override
    public void getBestOffer() {
        List<Book> books = getBooksInCartFromRepository();
        List<String> isbnList = getIsbnListFromBooks(books);

        mService.fetchOffers(isbnList, new OfferServiceContract.Callback() {
            @Override
            public void onSuccess(@NonNull List<Offer> offers) {
                List<Book> books = getBooksInCartFromRepository();
                double totalPrice = getTotalPriceForBooks(books);
                Offer bestOffer = mOfferOptimizer.getBestOffer(offers, totalPrice);
                if (bestOffer != null) {
                    mPresenter.presentBestOffer(bestOffer, bestOffer.getReducedPrice(totalPrice));
                } else {
                    mPresenter.presentNoOffer();
                }
            }

            @Override
            public void onFailure() {
                // TODO : impl
            }
        });
    }

    /**
     * Provides the book list present in the cart from the repository.
     * @return The book list.
     */
    private List<Book> getBooksInCartFromRepository() {
        return mRepository.getCartBooks();
    }

    /**
     * Provides the total price for the specified books.
     * @param books the books
     * @return The total price.
     */
    private double getTotalPriceForBooks(List<Book> books) {
        double totalPrice = 0;
        for (Book book : books) {
            totalPrice += book.getPrice();
        }
        return totalPrice;
    }

    /**
     * Provides the isbn list from the specified books.
     * @param books the books
     * @return The isbn list.
     */
    @NonNull
    private List<String> getIsbnListFromBooks(@NonNull List<Book> books) {
        List<String> isbnList = new ArrayList<>();
        for (Book book : books) {
            isbnList.add(book.getIsbn());
        }

        return isbnList;
    }
}
