package fr.kvaternik.adrien.bookstore.view.viewholder;

import android.support.annotation.NonNull;
import android.view.View;
import android.widget.TextView;

import butterknife.BindView;
import fr.kvaternik.adrien.bookstore.R;
import fr.kvaternik.adrien.bookstore.presenter.VO.BookV0;

/**
 * The view holder for the book list.
 */
public class BookListViewHolder extends BaseViewHolder {

    @BindView(R.id.title_textview)
    TextView mTitleTextView;

    @BindView(R.id.price_textview)
    TextView mPriceTextView;

    public BookListViewHolder(View itemView) {
        super(itemView);
    }

    /**
     * Binds the book VO to the view.
     * @param bookV0 the book VO
     */
    public void bindVO(@NonNull BookV0 bookV0) {
        mTitleTextView.setText(bookV0.getTitle());
        mPriceTextView.setText(bookV0.getPrice());
        // TODO : use bookV0.getCover();
    }
}
