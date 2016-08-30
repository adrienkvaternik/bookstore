package fr.kvaternik.adrien.bookstore.model.service;

import android.support.annotation.Nullable;

import fr.kvaternik.adrien.bookstore.model.service.callback.Callback;
import retrofit2.Call;
import retrofit2.Response;

/**
 * The base class for services.
 */
public abstract class BaseService {

    /**
     * Enqueues the call.
     * @param call the call
     * @param <T> the response type
     */
    protected <T> void enqueueCall(Call<T> call, @Nullable final Callback<T> callback) {
        call.enqueue(new retrofit2.Callback<T>() {
            @Override
            public void onResponse(Call<T> call, Response<T> response) {
                if (callback != null) {
                    if (response == null || !response.isSuccessful()) {
                        callback.onFailure();
                    } else {
                        callback.onSuccess(response.body());
                    }
                }
            }

            @Override
            public void onFailure(Call<T> call, Throwable t) {
                if (callback != null) {
                    callback.onFailure();
                }
            }
        });
    }
}
