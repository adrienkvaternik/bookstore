package fr.kvaternik.adrien.bookstore.view.adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

import fr.kvaternik.adrien.bookstore.R;
import fr.kvaternik.adrien.bookstore.presenter.VO.BookV0;
import fr.kvaternik.adrien.bookstore.view.viewholder.CartViewHolder;

/**
 * The adapter used to display the cart.
 */
public class CartAdapter extends RecyclerView.Adapter<CartViewHolder>{

    private List<BookV0> mBookV0s;

    public CartAdapter(@NonNull List<BookV0> bookV0s) {
        mBookV0s = bookV0s;
    }

    @Override
    public CartViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_cart, parent, false);
        return new CartViewHolder(view);
    }

    @Override
    public void onBindViewHolder(CartViewHolder holder, int position) {
        BookV0 bookV0 = mBookV0s.get(position);
        holder.bindVO(bookV0);
    }

    @Override
    public int getItemCount() {
        return mBookV0s.size();
    }
}
