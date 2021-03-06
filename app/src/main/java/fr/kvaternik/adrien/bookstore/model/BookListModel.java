package fr.kvaternik.adrien.bookstore.model;

import android.support.annotation.NonNull;

import java.util.List;

import fr.kvaternik.adrien.bookstore.model.entity.Book;
import fr.kvaternik.adrien.bookstore.model.repository.BookRepository;
import fr.kvaternik.adrien.bookstore.model.service.BookServiceContract;
import fr.kvaternik.adrien.bookstore.model.service.callback.Callback;
import fr.kvaternik.adrien.bookstore.mvpcontract.BookListMVP;

/**
 * The model for the book list.
 */
public class BookListModel extends BaseModel<BookListMVP.RequiredPresenterOperations> implements BookListMVP.ProvidedModelOperations {

    private BookServiceContract mService;
    private BookRepository mRepository;

    public void setService(BookServiceContract service) {
        mService = service;
    }

    public void setRepository(BookRepository repository) {
        mRepository = repository;
    }

    @Override
    public void getBooks() {
        mService.fetchBooks(new Callback<List<Book>>() {
            @Override
            public void onSuccess(@NonNull List<Book> books) {
                mRepository.resetWithBooks(books);
                if (!books.isEmpty()) {
                    mPresenter.presentBooks(books);
                } else {
                    mPresenter.presentNoBook();
                }
            }

            @Override
            public void onFailure() {
                mPresenter.presentError();
            }
        });
    }

    @Override
    public void addBookToCart(String isbn) {
        mRepository.addBookToCart(isbn);
    }

    @Override
    public void removeBookFromCart(String isbn) {
        mRepository.removeBookFromCart(isbn);
    }
}
