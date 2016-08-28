package fr.kvaternik.adrien.bookstore.view.adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import fr.kvaternik.adrien.bookstore.R;
import fr.kvaternik.adrien.bookstore.presenter.VO.BookVO;
import fr.kvaternik.adrien.bookstore.view.viewholder.BookListViewHolder;

/**
 * The adapter used to display the book list.
 */
public class BookListAdapter extends RecyclerView.Adapter<BookListViewHolder> {

    private List<BookVO> mBookVOs = new ArrayList<>();

    public BookListAdapter(@NonNull List<BookVO> bookVOs) {
        mBookVOs = bookVOs;
    }

    @Override
    public BookListViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_book_list, parent, false);
        return new BookListViewHolder(view);
    }

    @Override
    public void onBindViewHolder(BookListViewHolder holder, int position) {
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
