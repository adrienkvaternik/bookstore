package fr.kvaternik.adrien.bookstore.mvpcontract;

import android.support.annotation.NonNull;

import java.util.List;

import fr.kvaternik.adrien.bookstore.model.entity.Book;
import fr.kvaternik.adrien.bookstore.presenter.VO.CartVO;

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