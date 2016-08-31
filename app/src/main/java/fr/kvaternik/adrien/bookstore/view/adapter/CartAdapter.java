package fr.kvaternik.adrien.bookstore.view.adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

import fr.kvaternik.adrien.bookstore.R;
import fr.kvaternik.adrien.bookstore.presenter.VO.BookVO;
import fr.kvaternik.adrien.bookstore.view.viewholder.BookViewHolder;

/**
 * The adapter used to display the cart.
 */
public class CartAdapter extends RecyclerView.Adapter<BookViewHolder> {

    private List<BookVO> mBookVOs;

    public CartAdapter(@NonNull List<BookVO> bookVOs) {
        mBookVOs = bookVOs;
    }

    @Override
    public BookViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_cart, parent, false);
        return new BookViewHolder(view);
    }

    @Override
    public void onBindViewHolder(BookViewHolder holder, int position) {
        BookVO bookVO = mBookVOs.get(position);
        holder.bindVO(bookVO);
    }

    @Override
    public int getItemCount() {
        return mBookVOs.size();
    }

    /**
     * Updates the adapter data and notifies the data change.
     * @param bookVOs the new book VOs
     */
    public void updateData(@NonNull List<BookVO> bookVOs) {
        mBookVOs = bookVOs;
        notifyDataSetChanged();
    }
}
