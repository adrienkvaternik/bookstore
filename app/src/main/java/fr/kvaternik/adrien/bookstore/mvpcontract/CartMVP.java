package fr.kvaternik.adrien.bookstore.mvpcontract;

import android.support.annotation.NonNull;

import java.util.List;

import fr.kvaternik.adrien.bookstore.model.entity.Book;

/**
 * The MVP contract for the cart functionality.
 */
public interface CartMVP {

    /**
     * Operations that the view is required to implement so that the presenter can interact with it.
     */
    interface RequiredViewOperations extends AttachmentMVP.View<ProvidedPresenterOperations> {

    }

    /**
     * Operations provided by the presenter to the view.
     */
    interface ProvidedPresenterOperations extends AttachmentMVP.Presenter<RequiredViewOperations,ProvidedModelOperations> {
        /**
         * Requests the cart.
         */
        void requestCart();
    }

    /**
     * Operations that the presenter is required to implement so that the model can interact with it.
     */
    interface RequiredPresenterOperations {

        /**
         * Presents the cart
         * @param books the list of {@link Book} to present
         */
        void presentCart(@NonNull List<Book> books);
    }

    /**
     * Operations provided by the model to the presenter.
     */
    interface ProvidedModelOperations extends AttachmentMVP.Model<RequiredPresenterOperations> {

        /**
         * Provides the cart.
         */
        void getCart();
    }
}