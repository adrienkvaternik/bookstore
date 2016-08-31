package fr.kvaternik.adrien.bookstore.view.viewholder;

import android.support.v7.widget.RecyclerView;
import android.view.View;

import butterknife.ButterKnife;

/**
 * The base class for view holders.
 * @param <T> the type of data to bind to the views
 */
public abstract class BaseViewHolder<T> extends RecyclerView.ViewHolder {

    public BaseViewHolder(View itemView) {
        super(itemView);
        ButterKnife.bind(this, itemView);
    }

    /**
     * Binds the data to the view.
     * @param data the data to bind
     */
    public abstract void bindVO(T data);
}
