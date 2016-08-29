package fr.kvaternik.adrien.bookstore.view.viewholder;

import android.net.Uri;
import android.support.annotation.NonNull;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import butterknife.BindView;
import fr.kvaternik.adrien.bookstore.R;
import fr.kvaternik.adrien.bookstore.presenter.VO.BookVO;

/**
 * The view holder for the book list.
 */
public class BookListViewHolder extends BaseViewHolder {

    @BindView(R.id.title_textview)
    TextView mTitleTextView;

    @BindView(R.id.price_textview)
    TextView mPriceTextView;

    @BindView(R.id.cover_imageview)
    ImageView mCoverImageView;

    @BindView(R.id.add_to_cart_checkbox)
    CheckBox mAddToCartCheckBox;

    public BookListViewHolder(View itemView) {
        super(itemView);
    }

    /**
     * Binds the book VO to the view.
     * @param bookVO the book VO
     */
    public void bindVO(@NonNull final BookVO bookVO) {
        mTitleTextView.setText(bookVO.getTitle());
        mPriceTextView.setText(bookVO.getPrice());
        Picasso.with(itemView.getContext())
                .load(Uri.parse(bookVO.getCover()))
                .into(mCoverImageView);
        // TODO : add placeholder and error images
        mAddToCartCheckBox.setChecked(bookVO.isAddedToCart());
        mAddToCartCheckBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean isChecked) {
                bookVO.setAddedToCart(isChecked);
                // TODO : listener
            }
        });
    }
}
