package fr.kvaternik.adrien.bookstore.model;

import android.support.annotation.NonNull;

import java.util.List;

import fr.kvaternik.adrien.bookstore.model.entity.Book;
import fr.kvaternik.adrien.bookstore.model.service.BookService;
import fr.kvaternik.adrien.bookstore.mvpcontract.BookListMVP;

/**
 * The model for the book list.
 */
public class BookListModel implements BookListMVP.ProvidedModelOperations {

    private BookListMVP.RequiredPresenterOperations mPresenter;
    private BookService mService;

    @Override
    public void attachPresenter(BookListMVP.RequiredPresenterOperations presenter) {
        mPresenter = presenter;
    }

    @Override
    public void getBooks() {
        mService.fetchBooks(new BookService.Callback() {
            @Override
            public void onSuccess(@NonNull List<Book> books) {
                mPresenter.presentBooks(books);
            }

            @Override
            public void onFailure() {
                mPresenter.presentError();
            }
        });
    }

    public void setService(BookService service) {
        mService = service;
    }
}
