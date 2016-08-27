package fr.kvaternik.adrien.bookstore.mvpcontract;

import android.support.annotation.NonNull;

import java.util.List;

import fr.kvaternik.adrien.bookstore.model.entity.Book;
import fr.kvaternik.adrien.bookstore.presenter.VO.BookV0;

/**
 * The MVP contract for the book list functionality.
 */
public interface BookListMVP {

    /**
     * Operations that the view is required to implement so that the presenter can interact with it.
     */
    interface RequiredViewOperations {
        /**
         * Updates the book list.
         * @param bookVOs the list of visual objects for the books
         */
        void updateBookList(@NonNull List<BookV0> bookVOs);
    }

    /**
     * Operations provided by the presenter to the view.
     */
    interface ProvidedPresenterOperations extends AttachmentMVP.Presenter<RequiredViewOperations,ProvidedModelOperations> {
        /**
         * Requests the books.
         */
        void requestBooks();
    }

    /**
     * Operations that the presenter is required to implement so that the model can interact with it.
     */
    interface RequiredPresenterOperations {
        /**
         * Presents the specified books.
         * @param books the books to present
         */
        void presentBooks(@NonNull List<Book> books);
    }

    /**
     * Operations provided by the model to the presenter.
     */
    interface ProvidedModelOperations extends AttachmentMVP.Model<RequiredPresenterOperations> {
        /**
         * Provides the books.
         */
        void getBooks();
    }
}
