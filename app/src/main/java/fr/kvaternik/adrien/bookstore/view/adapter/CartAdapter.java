package fr.kvaternik.adrien.bookstore.view.adapter;

import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.view.View;

import java.util.List;

import fr.kvaternik.adrien.bookstore.R;
import fr.kvaternik.adrien.bookstore.presenter.VO.BookVO;
import fr.kvaternik.adrien.bookstore.view.viewholder.BookViewHolder;

/**
 * The adapter used to display the cart.
 */
public class CartAdapter extends BookAdapter<BookViewHolder> {

    public CartAdapter(@NonNull List<BookVO> bookVOs) {
        super(bookVOs);
    }

    @LayoutRes
    @Override
    protected int getItemLayoutIdentifier() {
        return R.layout.item_cart;
    }

    @NonNull
    @Override
    protected BookViewHolder getViewHolder(@NonNull View view) {
        return new BookViewHolder(view);
    }
}
