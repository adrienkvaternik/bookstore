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
public class CartActivity extends RefreshableActivity implements CartMVP.RequiredViewOperations {

    private CartMVPConfigurator mConfigurator;
    private CartMVP.ProvidedPresenterOperations mPresenter;
    private CartAdapter mAdapter;

    @BindView(R.id.cart_layout)
    View mCartLayout;

    @BindView(R.id.empty_cart_view)
    View mEmptyCartView;

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

        // display empty cart view
        displayEmptyCartView();

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

    @Override
    protected void onSwipeRefresh() {
        requestBestOffer();
    }

    @Override
    public void attachPresenter(CartMVP.ProvidedPresenterOperations presenter) {
        mPresenter = presenter;
    }

    @Override
    public void showCart(@NonNull CartVO cartVO) {
        displayCartLayout();
        mAdapter.updateData(cartVO.getBookVOs());
        mTotalPriceTextView.setText(cartVO.getTotalPrice());

        // request the best offer
        requestBestOffer();
    }

    @Override
    public void showEmptyCart() {
        disableRefreshIndicator();
        displayEmptyCartView();
    }

    @Override
    public void showOffer(@NonNull OfferVO offerVO) {
        hideRefreshIndicator();
        displayOfferLayout();
        mOfferValueTextView.setText(offerVO.getOfferValue());
        mReducedPriceTextView.setText(offerVO.getReducedPrice());
    }

    @Override
    public void showNoOffer() {
        hideRefreshIndicator();
        hideOfferLayout();
    }

    @Override
    public void showError() {
        hideRefreshIndicator();
        new AlertDialog.Builder(this)
                .setTitle(R.string.error_title)
                .setMessage(R.string.error_message_offer)
                .setPositiveButton(R.string.yes, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        // User accepts retry
                        requestBestOffer();
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
     * Requests the best offer.
     */
    private void requestBestOffer() {
        showRefreshIndicator();
        mPresenter.requestBestOffer();
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

    /**
     * Displays the cart layout.
     */
    private void displayCartLayout() {
        mEmptyCartView.setVisibility(View.GONE);
        mCartLayout.setVisibility(View.VISIBLE);
    }

    /**
     * Displays the cart layout.
     */
    private void displayEmptyCartView() {
        mCartLayout.setVisibility(View.GONE);
        mEmptyCartView.setVisibility(View.VISIBLE);
    }
}
