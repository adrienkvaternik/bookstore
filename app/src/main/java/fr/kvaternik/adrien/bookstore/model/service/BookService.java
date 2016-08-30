package fr.kvaternik.adrien.bookstore.model.service;

import android.support.annotation.Nullable;

import java.util.List;

import fr.kvaternik.adrien.bookstore.model.entity.Book;
import fr.kvaternik.adrien.bookstore.model.service.API.BookAPI;
import fr.kvaternik.adrien.bookstore.model.service.API.provider.BookAPIProvider;
import fr.kvaternik.adrien.bookstore.model.service.callback.Callback;

/**
 * The service providing the books.
 */
public class BookService extends BaseService implements BookServiceContract {

    private BookAPIProvider mAPIProvider;

    @Override
    public void fetchBooks(@Nullable final Callback<List<Book>> callback) {
        BookAPI bookAPI = mAPIProvider.getBookAPI();
        enqueueCall(bookAPI.fetchBooks(), callback);
    }

    public void setAPIProvider(BookAPIProvider apiProvider) {
        mAPIProvider = apiProvider;
    }
}
