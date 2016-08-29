package fr.kvaternik.adrien.bookstore.router;

import android.content.Context;
import android.support.annotation.NonNull;

/**
 * The book list router contract.
 */
public interface BookListRouterContract {

    /**
     * Handles the navigation to the cart.
     * @param context the context
     */
    void navigateToCart(@NonNull Context context);
}
