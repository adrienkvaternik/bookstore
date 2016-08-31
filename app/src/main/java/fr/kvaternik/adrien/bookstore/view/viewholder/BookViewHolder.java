package fr.kvaternik.adrien.bookstore.view.viewholder;

import android.net.Uri;
import android.support.annotation.NonNull;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import butterknife.BindView;
import fr.kvaternik.adrien.bookstore.R;
import fr.kvaternik.adrien.bookstore.presenter.VO.BookVO;

/**
 * A view holder that binds {@link BookVO} to display a book.
 */
public class BookViewHolder extends BaseViewHolder<BookVO> {

    @BindView(R.id.title_textview)
    TextView mTitleTextView;

    @BindView(R.id.price_textview)
    TextView mPriceTextView;

    @BindView(R.id.cover_imageview)
    ImageView mCoverImageView;

    public BookViewHolder(View itemView) {
        super(itemView);
    }

    @Override
    public void bindVO(@NonNull final BookVO bookVO) {
        mTitleTextView.setText(bookVO.getTitle());
        mPriceTextView.setText(bookVO.getPrice());
        Picasso.with(itemView.getContext())
                .load(Uri.parse(bookVO.getCover()))
                .into(mCoverImageView);
        // TODO : add placeholder and error images
    }
}
