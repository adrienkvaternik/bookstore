package fr.kvaternik.adrien.bookstore.view.activity;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.TextView;

import java.util.ArrayList;

import butterknife.BindView;
import fr.kvaternik.adrien.bookstore.R;
import fr.kvaternik.adrien.bookstore.mvpconfigurator.CartMVPConfigurator;
import fr.kvaternik.adrien.bookstore.mvpcontract.CartMVP;
import fr.kvaternik.adrien.bookstore.presenter.VO.BookVO;
import fr.kvaternik.adrien.bookstore.presenter.VO.CartVO;
import fr.kvaternik.adrien.bookstore.presenter.VO.OfferVO;
import fr.kvaternik.adrien.bookstore.view.adapter.CartAdapter;

/**
 * The cart activity.
 */
public class CartActivity extends BaseActivity implements CartMVP.RequiredViewOperations {

    private CartMVPConfigurator mConfigurator;
    private CartMVP.ProvidedPresenterOperations mPresenter;
    private CartAdapter mAdapter;

    @BindView(R.id.cart_recylerview)
    RecyclerView mRecyclerView;

    @BindView(R.id.total_price_textview)
    TextView mTotalPriceTextView;

    @BindView(R.id.offer_value_textview)
    TextView mOfferValueTextView;

    @BindView(R.id.reduced_price_textview)
    TextView mReducedPriceTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // setup adapter
        mAdapter = new CartAdapter(new ArrayList<BookVO>());

        // setup recyclerview
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        mRecyclerView.setAdapter(mAdapter);

        // create MVP with configurator
        mConfigurator = new CartMVPConfigurator();
        mConfigurator.createMVPWithView(this);

        // request the cart information
        mPresenter.requestCart();

        // request the best offer
        mPresenter.requestBestOffer();
    }

    @Override
    public void onDestroy() {
        // destroy MVP with configurator
        mConfigurator.destroyMVPWithPresenter(mPresenter);
        super.onDestroy();
    }

    @Override
    protected int getContentViewId() {
        return R.layout.activity_cart;
    }

    @NonNull
    @Override
    protected String getActivityTitle() {
        return getString(R.string.title_cart);
    }

    @Override
    public void attachPresenter(CartMVP.ProvidedPresenterOperations presenter) {
        mPresenter = presenter;
    }

    @Override
    public void updateCart(@NonNull CartVO cartVO) {
        mAdapter.updateData(cartVO.getBookVOs());
        mTotalPriceTextView.setText(cartVO.getTotalPrice());
    }

    @Override
    public void updateOffer(@NonNull OfferVO offerVO) {
        mOfferValueTextView.setText(offerVO.getOfferValue());
        mReducedPriceTextView.setText(offerVO.getReducedPrice());
    }
}
