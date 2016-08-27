package fr.kvaternik.adrien.bookstore.presenter;

import fr.kvaternik.adrien.bookstore.mvpcontract.BookListMVP;

/**
 * The presenter for the book list.
 */
public class BookListPresenter implements BookListMVP.ProvidedPresenterOperations<BookListMVP.RequiredViewOperations, BookListMVP.ProvidedModelOperations>,
        BookListMVP.RequiredPresenterOperations {

    private BookListMVP.RequiredViewOperations mView;
    private BookListMVP.ProvidedModelOperations mModel;

    @Override
    public void attachView(BookListMVP.RequiredViewOperations view) {
        mView = view;
    }

    @Override
    public void detachView() {
        mView = null;
    }

    @Override
    public void attachModel(BookListMVP.ProvidedModelOperations model) {
        mModel = model;
    }

    @Override
    public void detachModel() {
        mModel = null;
    }
}
