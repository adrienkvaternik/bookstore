package fr.kvaternik.adrien.bookstore.view.adapter;

import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.view.View;

import java.util.List;

import fr.kvaternik.adrien.bookstore.R;
import fr.kvaternik.adrien.bookstore.presenter.VO.BookVO;
import fr.kvaternik.adrien.bookstore.view.listener.OnBookAddedToCartChangeListener;
import fr.kvaternik.adrien.bookstore.view.viewholder.SelectableBookViewHolder;

/**
 * The adapter used to display the book list.
 */
public class BookListAdapter extends BookAdapter<SelectableBookViewHolder> {

    private OnBookAddedToCartChangeListener mListener;

    public BookListAdapter(@NonNull List<BookVO> bookVOs, OnBookAddedToCartChangeListener mListener) {
        super(bookVOs);
        this.mListener = mListener;
    }

    @LayoutRes
    @Override
    protected int getItemLayoutIdentifier() {
        return R.layout.item_book_list;
    }

    @NonNull
    @Override
    protected SelectableBookViewHolder getViewHolder(@NonNull View view) {
        return new SelectableBookViewHolder(view, mListener);
    }
}
