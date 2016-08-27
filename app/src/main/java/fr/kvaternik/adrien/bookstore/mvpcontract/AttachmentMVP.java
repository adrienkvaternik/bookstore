package fr.kvaternik.adrien.bookstore.mvpcontract;

/**
 * The MVP contract to enable attachment/detachment of the MVP components.
 */
public interface AttachmentMVP {

    /**
     * Methods that a presenter needs to implement to enable attachment/detachment of the view.
     * @param <T> The view type.
     */
    interface Presenter<T> {
        /**
         * Used to attach the view to the presenter.
         * @param view the view to attach
         */
        void attachView(T view);

        /**
         * Used to detach the view from the presenter.
         */
        void detachView();
    }

    /**
     * Methods that a model needs to implement to enable attachment/detachment of the presenter.
     * @param <T> The presenter type.
     */
    interface Model<T> {
        /**
         * Used to attach the presenter to the model.
         * @param presenter the presenter to attach
         */
        void attachPresenter(T presenter);

        /**
         * Used to detach the presenter from the model.
         */
        void detachPresenter();
    }
}
