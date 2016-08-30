package fr.kvaternik.adrien.bookstore.mvpcontract;

import android.support.annotation.NonNull;

import java.util.List;

import fr.kvaternik.adrien.bookstore.model.entity.Book;
import fr.kvaternik.adrien.bookstore.model.entity.Offer;
import fr.kvaternik.adrien.bookstore.presenter.VO.CartVO;
import fr.kvaternik.adrien.bookstore.presenter.VO.OfferVO;

/**
 * The MVP contract for the cart functionality.
 */
public interface CartMVP {

    /**
     * Operations that the view is required to implement so that the presenter can interact with it.
     */
    interface RequiredViewOperations extends AttachmentMVP.View<ProvidedPresenterOperations> {

        /**
         * Shows the cart.
         * @param cartVO the visual object for the cart
         */
        void showCart(@NonNull CartVO cartVO);

        /**
         * Shows the offer.
         * @param offerVO the visual object for the offer
         */
        void showOffer(@NonNull OfferVO offerVO);

        /**
         * Shows the absence of offer.
         */
        void showNoOffer();

        /**
         * Shows an error.
         */
        void showError();
    }

    /**
     * Operations provided by the presenter to the view.
     */
    interface ProvidedPresenterOperations extends AttachmentMVP.Presenter<RequiredViewOperations,ProvidedModelOperations> {
        /**
         * Requests the cart.
         */
        void requestCart();

        /**
         * Requests the best offer.
         */
        void requestBestOffer();
    }

    /**
     * Operations that the presenter is required to implement so that the model can interact with it.
     */
    interface RequiredPresenterOperations {

        /**
         * Presents the cart.
         * @param books the list of {@link Book} to present
         * @param totalPrice the total price of the cart
         */
        void presentCart(@NonNull List<Book> books, double totalPrice);

        /**
         * Presents an empty cart.
         */
        void presentEmptyCart();

        /**
         * Presents the best offer.
         * @param bestOffer the best offer
         * @param reducedPrice the reduced price
         */
        void presentBestOffer(@NonNull Offer bestOffer, double reducedPrice);

        /**
         * Presents the absence of offer.
         */
        void presentNoOffer();

        /**
         * Presents the offer error.
         */
        void presentOfferError();
    }

    /**
     * Operations provided by the model to the presenter.
     */
    interface ProvidedModelOperations extends AttachmentMVP.Model<RequiredPresenterOperations> {

        /**
         * Provides the cart.
         */
        void getCart();

        /**
         * Provides the best offer.
         */
        void getBestOffer();
    }
}