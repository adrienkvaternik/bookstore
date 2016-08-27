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
     * @param <V> The view type.
     * @param <M> The model type.
     */
    interface ProvidedPresenterOperations<V,M> extends AttachmentMVP.Presenter<V,M> {

    }

    /**
     * Operations that the presenter is required to implement so that the model can interact with it.
     */
    interface RequiredPresenterOperations {

    }

    /**
     * Operations provided by the model to the presenter.
     * @param <P> The presenter type.
     */
    interface ProvidedModelOperations<P> extends AttachmentMVP.Model<P> {

    }
}
