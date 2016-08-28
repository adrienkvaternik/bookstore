package fr.kvaternik.adrien.bookstore.model.service;


import android.support.annotation.Nullable;

import java.util.List;

import fr.kvaternik.adrien.bookstore.model.service.API.BookAPI;
import fr.kvaternik.adrien.bookstore.model.service.API.provider.BookAPIProvider;
import fr.kvaternik.adrien.bookstore.model.entity.Book;
import retrofit2.Call;
import retrofit2.Response;

/**
 * The service providing the books.
 */
public class BookService implements BookServiceContract {

    private BookAPIProvider mAPIProvider;

    @Override
    public void fetchBooks(@Nullable final Callback callback) {
        BookAPI bookAPI = mAPIProvider.getBookAPI();

        bookAPI.fetchBooks().enqueue(new retrofit2.Callback<List<Book>>() {
            @Override
            public void onResponse(Call<List<Book>> call, Response<List<Book>> response) {
                if (response == null || !response.isSuccessful()) {
                    if (callback != null) {
                        callback.onFailure();
                    }
                } else {
                    if (callback != null) {
                        callback.onSuccess(response.body());
                    }
                }
            }

            @Override
            public void onFailure(Call<List<Book>> call, Throwable t) {
                if (callback != null) {
                    callback.onFailure();
                }
            }
        });
    }

    public void setAPIProvider(BookAPIProvider apiProvider) {
        mAPIProvider = apiProvider;
    }
}
