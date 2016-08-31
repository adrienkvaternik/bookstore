package fr.kvaternik.adrien.bookstore.view.viewholder;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;

import butterknife.BindView;
import fr.kvaternik.adrien.bookstore.R;
import fr.kvaternik.adrien.bookstore.presenter.VO.BookVO;
import fr.kvaternik.adrien.bookstore.view.listener.OnBookAddedToCartChangeListener;

/**
 * A view holder that binds {@link BookVO} to display a selectable book.
 */
public class SelectableBookViewHolder extends BookViewHolder {

    private final OnBookAddedToCartChangeListener mListener;

    @BindView(R.id.add_to_cart_checkbox)
    CheckBox mAddToCartCheckBox;

    public SelectableBookViewHolder(View itemView, @Nullable OnBookAddedToCartChangeListener mListener) {
        super(itemView);
        this.mListener = mListener;
    }

    @Override
    public void bindVO(@NonNull final BookVO bookVO) {
        super.bindVO(bookVO);

        mAddToCartCheckBox.setChecked(bookVO.isAddedToCart());
        mAddToCartCheckBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean isChecked) {
                bookVO.setAddedToCart(isChecked);
                if (mListener != null) {
                    if (isChecked) {
                        mListener.onBookAddedToCart(bookVO.getIsbn());
                    } else {
                        mListener.onBookRemovedFromCart(bookVO.getIsbn());
                    }
                }
            }
        });
    }
}
