package fr.kvaternik.adrien.bookstore.presenter;

import android.support.annotation.NonNull;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

import fr.kvaternik.adrien.bookstore.model.entity.Book;
import fr.kvaternik.adrien.bookstore.mvpcontract.BookListMVP;
import fr.kvaternik.adrien.bookstore.presenter.VO.BookVO;
import fr.kvaternik.adrien.bookstore.utils.DecimalFormatUtils;

/**
 * The presenter for the book list.
 */
public class BookListPresenter implements BookListMVP.ProvidedPresenterOperations, BookListMVP.RequiredPresenterOperations {

    /** Decimal formatter with 2 decimals, in euros, used to convert a {@link Book} into a {@link BookVO}, see method {@link #convertBookToBookVO(Book)} */
    private DecimalFormat mDecimalFormat = DecimalFormatUtils.decimalFormatEuros();

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
    public void onBookAddedToCart(String isbn) {
        mModel.addBookToCart(isbn);
    }

    @Override
    public void onBookRemovedFromCart(String isbn) {
        mModel.removeBookFromCart(isbn);
    }

    @Override
    public void presentBooks(@NonNull List<Book> books) {
        List<BookVO> bookVOs = new ArrayList<>();
        for (Book book : books) {
            bookVOs.add(convertBookToBookVO(book));
        }

        mView.updateBookList(bookVOs);
    }

    @Override
    public void presentError() {
        // TODO : impl
    }

    /**
     * Converts a {@link Book} into a {@link BookVO}.
     * @param book the book to convert.
     * @return The resulting {@link BookVO}.
     */
    @NonNull
    private BookVO convertBookToBookVO(@NonNull Book book) {
        return new BookVO(
                book.getIsbn(),
                book.getTitle(),
                mDecimalFormat.format(book.getPrice()),
                book.getCover(),
                false
        );
    }
}
