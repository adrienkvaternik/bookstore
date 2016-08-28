package fr.kvaternik.adrien.bookstore.view.adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import fr.kvaternik.adrien.bookstore.R;
import fr.kvaternik.adrien.bookstore.presenter.VO.BookV0;
import fr.kvaternik.adrien.bookstore.view.viewholder.BookListViewHolder;

/**
 * The adapter used to display the book list.
 */
public class BookListAdapter extends RecyclerView.Adapter<BookListViewHolder> {

    private List<BookV0> mBookV0s = new ArrayList<>();

    public BookListAdapter(@NonNull List<BookV0> bookV0s) {
        mBookV0s = bookV0s;
    }

    @Override
    public BookListViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_book_list, parent, false);
        return new BookListViewHolder(view);
    }

    @Override
    public void onBindViewHolder(BookListViewHolder holder, int position) {
        BookV0 bookV0 = mBookV0s.get(position);
        holder.bindVO(bookV0);
    }

    @Override
    public int getItemCount() {
        return mBookV0s.size();
    }

    /**
     * Updates the adapter data and notifies the data change.
     * @param bookV0s the new book VOs
     */
    public void updateData(@NonNull List<BookV0> bookV0s) {
        mBookV0s = bookV0s;
        notifyDataSetChanged();
    }
}
