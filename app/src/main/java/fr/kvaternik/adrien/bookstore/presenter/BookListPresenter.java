package fr.kvaternik.adrien.bookstore.presenter;

import android.support.annotation.NonNull;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

import fr.kvaternik.adrien.bookstore.model.entity.Book;
import fr.kvaternik.adrien.bookstore.model.mapper.BookToBookVOMapper;
import fr.kvaternik.adrien.bookstore.mvpcontract.BookListMVP;
import fr.kvaternik.adrien.bookstore.presenter.VO.BookVO;
import fr.kvaternik.adrien.bookstore.utils.DecimalFormatUtils;

/**
 * The presenter for the book list.
 */
public class BookListPresenter implements BookListMVP.ProvidedPresenterOperations, BookListMVP.RequiredPresenterOperations {

    /** Decimal formatter with 2 decimals, in euros */
    private DecimalFormat mDecimalFormatEuros = DecimalFormatUtils.decimalFormatEuros();

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
        BookToBookVOMapper mapper = new BookToBookVOMapper(mDecimalFormatEuros, false);

        List<BookVO> bookVOs = new ArrayList<>();
        for (Book book : books) {
            bookVOs.add(mapper.map(book));
        }

        mView.showBooks(bookVOs);
    }

    @Override
    public void presentError() {
        mView.showError();
    }

    @Override
    public void presentNoBook() {
        mView.showNoBook();
    }
}
