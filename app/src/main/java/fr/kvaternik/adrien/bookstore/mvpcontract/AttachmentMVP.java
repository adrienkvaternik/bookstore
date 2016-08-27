package fr.kvaternik.adrien.bookstore.mvpcontract;

/**
 * The MVP contract to enable attachment/detachment of the MVP components.
 */
public interface AttachmentMVP {

    /**
     * Methods that a presenter needs to implement to enable attachment/detachment of the view.
     * @param <V> The view type.
     * @param <M> The model type.
     */
    interface Presenter<V,M> {
        /**
         * Used to attach the view to the presenter.
         * @param view the view to attach
         */
        void attachView(V view);

        /**
         * Used to detach the view from the presenter.
         */
        void detachView();

        /**
         * Used to attach the model to the presenter.
         * @param model the model to attach
         */
        void attachModel(M model);

        /**
         * Used to detach the model from the presenter.
         */
        void detachModel();
    }

    /**
     * Methods that a model needs to implement to enable attachment/detachment of the presenter.
     * @param <P> The presenter type.
     */
    interface Model<P> {
        /**
         * Used to attach the presenter to the model.
         * @param presenter the presenter to attach
         */
        void attachPresenter(P presenter);
    }
}
