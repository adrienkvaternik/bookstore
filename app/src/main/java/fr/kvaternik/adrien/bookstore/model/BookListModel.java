package fr.kvaternik.adrien.bookstore.model;

import fr.kvaternik.adrien.bookstore.mvpcontract.BookListMVP;

/**
 * The model for the book list.
 */
public class BookListModel implements BookListMVP.ProvidedModelOperations<BookListMVP.RequiredPresenterOperations> {

    private BookListMVP.RequiredPresenterOperations mPresenter;

    @Override
    public void attachPresenter(BookListMVP.RequiredPresenterOperations presenter) {
        mPresenter = presenter;
    }

    @Override
    public void getBooks() {
        // TODO : impl
    }
}
