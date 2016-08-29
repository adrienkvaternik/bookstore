package fr.kvaternik.adrien.bookstore.router;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;

import fr.kvaternik.adrien.bookstore.view.activity.CartActivity;

/**
 * The book list router.
 */
public class BookListRouter implements BookListRouterContract {
    @Override
    public void navigateToCart(@NonNull Context context) {
        context.startActivity(new Intent(context, CartActivity.class));
    }
}
