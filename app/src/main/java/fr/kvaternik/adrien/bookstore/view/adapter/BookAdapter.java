package fr.kvaternik.adrien.bookstore.view.adapter;

import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import fr.kvaternik.adrien.bookstore.presenter.VO.BookVO;
import fr.kvaternik.adrien.bookstore.view.viewholder.BookViewHolder;

/**
 * The base class for book adapters.
 * @param <T> the view holder type
 */
public abstract class BookAdapter<T extends BookViewHolder> extends RecyclerView.Adapter<T> {

    private List<BookVO> mBookVOs = new ArrayList<>();

    public BookAdapter(@NonNull List<BookVO> bookVOs) {
        mBookVOs = bookVOs;
    }

    /**
     * Provides the item layout identifier.
     * @return The layout identifier.
     */
    @LayoutRes protected abstract int getItemLayoutIdentifier();

    /**
     * Provides the view holder with the specified view.
     * @param view the view
     * @return The view holder.
     */
    @NonNull protected abstract T getViewHolder(@NonNull View view);

    @Override
    public T onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(getItemLayoutIdentifier(), parent, false);
        return getViewHolder(view);
    }

    @Override
    public void onBindViewHolder(T holder, int position) {
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
