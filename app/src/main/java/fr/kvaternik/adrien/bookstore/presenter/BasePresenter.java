package fr.kvaternik.adrien.bookstore.presenter;

import fr.kvaternik.adrien.bookstore.mvpcontract.AttachmentMVP;

/**
 * The base class for the presenters.
 * @param <V> the view type
 * @param <M> the model type
 */
public abstract class BasePresenter<V,M> implements AttachmentMVP.Presenter<V,M> {

    protected V mView;
    protected M mModel;

    @Override
    public void attachView(V view) {
        mView = view;
    }

    @Override
    public void detachView() {
        mView = null;
    }

    @Override
    public void attachModel(M model) {
        mModel = model;
    }

    @Override
    public void detachModel() {
        mModel = null;
    }
}
