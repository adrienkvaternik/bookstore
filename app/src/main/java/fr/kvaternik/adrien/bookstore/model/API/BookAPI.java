package fr.kvaternik.adrien.bookstore.model.api;

import java.util.List;

import fr.kvaternik.adrien.bookstore.model.entity.Book;
import retrofit2.Call;
import retrofit2.http.GET;

/**
 * The book API, used to fetch books from the network.
 */
public interface BookAPI {

    /**
     * Fetchs the book list
     * @return The call.
     */
    @GET("books")
    Call<List<Book>> fetchBooks();
}
