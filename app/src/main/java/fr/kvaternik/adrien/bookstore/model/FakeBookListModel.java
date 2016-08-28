package fr.kvaternik.adrien.bookstore.model;

import java.util.ArrayList;

import fr.kvaternik.adrien.bookstore.model.entity.Book;
import fr.kvaternik.adrien.bookstore.mvpcontract.BookListMVP;

/**
 * A fake model book list model. Used only for view manual testing.
 */
public class FakeBookListModel implements BookListMVP.ProvidedModelOperations {

    BookListMVP.RequiredPresenterOperations mPresenter;

    @Override
    public void attachPresenter(BookListMVP.RequiredPresenterOperations presenter) {
        mPresenter = presenter;
    }

    @Override
    public void getBooks() {
        ArrayList<Book> books = new ArrayList<>();
        books.add(new Book("", "Mon titre", 12, ""));
        books.add(new Book("", "Mon titre", 12, ""));
        books.add(new Book("", "Mon titre", 12, ""));
        books.add(new Book("", "Mon titre", 12, ""));

        mPresenter.presentBooks(books);
    }
}
