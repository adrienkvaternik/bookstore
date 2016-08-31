package fr.kvaternik.adrien.bookstore.model;

import fr.kvaternik.adrien.bookstore.mvpcontract.AttachmentMVP;

/**
 * The base class for the models.
 * @param <P> the presenter type
 */
public class BaseModel<P> implements AttachmentMVP.Model<P> {

    protected P mPresenter;

    @Override
    public void attachPresenter(P presenter) {
        mPresenter = presenter;
    }
}
