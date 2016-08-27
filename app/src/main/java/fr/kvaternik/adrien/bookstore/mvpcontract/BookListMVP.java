package fr.kvaternik.adrien.bookstore.mvpcontract;

/**
 * The MVP contract for the book list functionality.
 */
public interface BookListMVP {

    /**
     * Operations that the view is required to implement so that the presenter can interact with it.
     */
    interface RequiredViewOperations {

    }

    /**
     * Operations provided by the presenter to the view.
     */
    interface ProvidedPresenterOperations<T> extends AttachmentMVP.Presenter<T> {

    }

    /**
     * Operations that the presenter is required to implement so that the model can interact with it.
     */
    interface RequiredPresenterOperations {

    }

    /**
     * Operations provided by the model to the presenter.
     */
    interface ProvidedModelOperations<T> extends AttachmentMVP.Model<T> {

    }
}
