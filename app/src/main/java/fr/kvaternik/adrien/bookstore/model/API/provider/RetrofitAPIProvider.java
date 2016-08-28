package fr.kvaternik.adrien.bookstore.model.api.provider;

import android.support.annotation.NonNull;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import fr.kvaternik.adrien.bookstore.model.api.BookAPI;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * The Retrofit API provider. Provides the API using Retrofit.
 */
public class RetrofitAPIProvider implements BookAPIProvider {

    public static final String RETROFIT_BASE_URL = "http://henri-potier.xebia.fr/";

    private Retrofit mRetrofit;
    private BookAPI mBookAPI;

    // private constructor to prevent external instantiation of singleton
    private RetrofitAPIProvider() {}

    @NonNull
    @Override
    public BookAPI getBookAPI() {
        if (mBookAPI == null) {
            mBookAPI = createBookAPI();
        }
        return mBookAPI;
    }

    /**
     * Provides the unique {@link RetrofitAPIProvider} instance.
     * @return The unique {@link RetrofitAPIProvider} instance.
     */
    @NonNull
    public static RetrofitAPIProvider getInstance() {
        return Holder.INSTANCE;
    }

    /**
     * Creates a book API.
     * @return A new instance of {@link BookAPI}.
     */
    @NonNull
    private BookAPI createBookAPI() {
        if (mRetrofit == null) {
            mRetrofit = createRetrofit();
        }
        return mRetrofit.create(BookAPI.class);
    }

    /**
     * Creates and configures a {@link Retrofit} instance.
     * @return The {@link Retrofit} instance.
     */
    @NonNull
    private Retrofit createRetrofit() {
        // setup logging interceptor
        HttpLoggingInterceptor loggingInterceptor = new HttpLoggingInterceptor();
        loggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);

        // setup http client
        OkHttpClient client = new OkHttpClient.Builder()
                .addInterceptor(loggingInterceptor)
                .build();

        // setup Gson
        Gson gson = new GsonBuilder()
                .create();

        // create and return the configured Retrofit
        return new Retrofit.Builder()
                .baseUrl(RETROFIT_BASE_URL)
                .client(client)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();
    }

    /**
     * The API provider holder.
     */
    private static final class Holder {
        static final RetrofitAPIProvider INSTANCE = new RetrofitAPIProvider();

        private Holder() {}
    }
}
