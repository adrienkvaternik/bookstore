package fr.kvaternik.adrien.bookstore.presenter;

import android.support.annotation.NonNull;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

import fr.kvaternik.adrien.bookstore.model.entity.Book;
import fr.kvaternik.adrien.bookstore.mvpcontract.BookListMVP;
import fr.kvaternik.adrien.bookstore.presenter.VO.BookV0;

/**
 * The presenter for the book list.
 */
public class BookListPresenter implements BookListMVP.ProvidedPresenterOperations, BookListMVP.RequiredPresenterOperations {

    /** Decimal formatter with 2 decimals, used to convert a {@link Book} into a {@link BookV0}, see method {@link #convertBookToBookVO(Book)} */
    private DecimalFormat mDecimalFormat = new DecimalFormat("#.00");

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

    @Override
    public void requestBooks() {
        mModel.getBooks();
    }

    @Override
    public void presentBooks(@NonNull List<Book> books) {
        List<BookV0> bookV0s = new ArrayList<>();
        for (Book book : books) {
            bookV0s.add(convertBookToBookVO(book));
        }

        mView.updateBookList(bookV0s);
    }

    /**
     * Converts a {@link Book} into a {@link BookV0}.
     * @param book the book to convert.
     * @return The resulting {@link BookV0}.
     */
    @NonNull
    private BookV0 convertBookToBookVO(@NonNull Book book) {
        return new BookV0(
                book.getIsbn(),
                book.getTitle(),
                mDecimalFormat.format(book.getPrice()),
                book.getCover()
        );
    }
}
