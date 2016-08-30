package fr.kvaternik.adrien.bookstore.model.service.callback;

import android.support.annotation.NonNull;

/**
 * The service callback.
 */
public interface Callback<T> {
    /**
     * Called on success case.
     * @param response the received response
     */
    void onSuccess(@NonNull T response);

    /**
     * Called on failure case.
     */
    void onFailure();
}
