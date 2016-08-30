package fr.kvaternik.adrien.bookstore.model.service.API.provider;

import android.support.annotation.NonNull;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import java.util.List;

import fr.kvaternik.adrien.bookstore.model.entity.MinusOffer;
import fr.kvaternik.adrien.bookstore.model.entity.Offer;
import fr.kvaternik.adrien.bookstore.model.entity.PercentageOffer;
import fr.kvaternik.adrien.bookstore.model.entity.SliceOffer;
import fr.kvaternik.adrien.bookstore.model.service.API.BookAPI;
import fr.kvaternik.adrien.bookstore.model.service.API.OfferAPI;
import fr.kvaternik.adrien.bookstore.model.service.adapterfactory.RuntimeTypeAdapterFactory;
import fr.kvaternik.adrien.bookstore.model.service.deserializer.OfferListDeserializer;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * The Retrofit API provider. Provides the API using Retrofit.
 */
public class RetrofitAPIProvider implements BookAPIProvider, OfferAPIProvider {

    public static final String RETROFIT_BASE_URL = "http://henri-potier.xebia.fr/";

    private Retrofit mRetrofit;
    private BookAPI mBookAPI;
    private OfferAPI mOfferAPI;

    // private constructor to prevent external instantiation of singleton
    private RetrofitAPIProvider() {}

    @NonNull
    @Override
    public BookAPI getBookAPI() {
        if (mBookAPI == null) {
            mBookAPI = createAPI(BookAPI.class);
        }
        return mBookAPI;
    }

    @Override
    public OfferAPI getOfferAPI() {
        if (mOfferAPI == null) {
            mOfferAPI = createAPI(OfferAPI.class);
        }
        return mOfferAPI;
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
     * Creates an API of the specified type class.
     * @param clazz the API type class
     * @param <T> the API type
     * @return A new API instance.
     */
    private <T> T createAPI(Class<T> clazz) {
        if (mRetrofit == null) {
            mRetrofit = createRetrofit();
        }
        return mRetrofit.create(clazz);
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

        // setup type adapter factory for offers
        RuntimeTypeAdapterFactory<Offer> offerAdapterFactory = RuntimeTypeAdapterFactory.of(Offer.class, "type");
        offerAdapterFactory.registerSubtype(PercentageOffer.class, "percentage");
        offerAdapterFactory.registerSubtype(MinusOffer.class, "minus");
        offerAdapterFactory.registerSubtype(SliceOffer.class, "slice");

        // setup Gson
        Gson gson = new GsonBuilder()
                .registerTypeAdapterFactory(offerAdapterFactory)
                .registerTypeAdapter(new TypeToken<List<Offer>>() {}.getType(), new OfferListDeserializer())
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
