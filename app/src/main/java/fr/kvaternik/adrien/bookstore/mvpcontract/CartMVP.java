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
         * Updates the cart.
         * @param cartVO the visual object for the cart
         */
        void updateCart(@NonNull CartVO cartVO);

        /**
         * Update the offer.
         * @param offerVO the visual object for the offer
         */
        void updateOffer(@NonNull OfferVO offerVO);
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
         * Presents the best offer.
         * @param bestOffer the best offer
         * @param reductedPrice the reducted price
         */
        void presentBestOffer(@NonNull Offer bestOffer, double reductedPrice);

        /**
         * Present the absence of offer.
         */
        void presentNoOffer();
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