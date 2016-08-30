package fr.kvaternik.adrien.bookstore.view.activity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
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

    @BindView(R.id.offer_layout)
    View mOfferLayout;

    @BindView(R.id.offer_value_textview)
    TextView mOfferValueTextView;

    @BindView(R.id.reduced_price_textview)
    TextView mReducedPriceTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // hide offer layout
        hideOfferLayout();

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

    // TODO : add showEmptyCart

    @Override
    public void showCart(@NonNull CartVO cartVO) {
        mAdapter.updateData(cartVO.getBookVOs());
        mTotalPriceTextView.setText(cartVO.getTotalPrice());
    }

    @Override
    public void showOffer(@NonNull OfferVO offerVO) {
        displayOfferLayout();
        mOfferValueTextView.setText(offerVO.getOfferValue());
        mReducedPriceTextView.setText(offerVO.getReducedPrice());
    }

    @Override
    public void showNoOffer() {
        hideOfferLayout();
    }

    @Override
    public void showError() {
        new AlertDialog.Builder(this)
                .setTitle(R.string.error_title)
                .setMessage(R.string.error_message_offer)
                .setPositiveButton(R.string.yes, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        // User accepts retry
                        mPresenter.requestBestOffer();
                    }
                })
                .setNegativeButton(R.string.no, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int i) {
                        // User refuses retry
                    }
                })
                .create()
                .show();
    }

    /**
     * Hides the offer layout.
     */
    private void hideOfferLayout() {
        mOfferLayout.setVisibility(View.GONE);
    }

    /**
     * Displays the offer layout.
     */
    private void displayOfferLayout() {
        mOfferLayout.setVisibility(View.VISIBLE);
    }
}
