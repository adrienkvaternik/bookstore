package fr.kvaternik.adrien.bookstore.view.viewholder;

import android.net.Uri;
import android.support.annotation.NonNull;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import butterknife.BindView;
import fr.kvaternik.adrien.bookstore.R;
import fr.kvaternik.adrien.bookstore.presenter.VO.BookV0;

/**
 * The view holder for the cart.
 */
public class CartViewHolder extends BaseViewHolder {

    @BindView(R.id.title_textview)
    TextView mTitleTextView;

    @BindView(R.id.price_textview)
    TextView mPriceTextView;

    @BindView(R.id.cover_imageview)
    ImageView mCoverImageView;

    public CartViewHolder(View itemView) {
        super(itemView);
    }

    /**
     * Binds the book VO to the view.
     * @param bookV0 the book VO
     */
    public void bindVO(@NonNull BookV0 bookV0) {
        mTitleTextView.setText(bookV0.getTitle());
        mPriceTextView.setText(bookV0.getPrice());
        Picasso.with(itemView.getContext())
                .load(Uri.parse(bookV0.getCover()))
                .into(mCoverImageView);
        // TODO : add placeholder and error images
    }
}
