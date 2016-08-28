package fr.kvaternik.adrien.bookstore.view.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

import butterknife.BindView;
import fr.kvaternik.adrien.bookstore.R;
import fr.kvaternik.adrien.bookstore.mvpconfigurator.CartMVPConfigurator;
import fr.kvaternik.adrien.bookstore.mvpcontract.CartMVP;
import fr.kvaternik.adrien.bookstore.presenter.VO.BookV0;
import fr.kvaternik.adrien.bookstore.view.adapter.CartAdapter;

/**
 * The fragment used to display the cart.
 */
public class CartFragment extends BaseFragment implements CartMVP.RequiredViewOperations {

    private CartMVPConfigurator mConfigurator;
    private CartMVP.ProvidedPresenterOperations mPresenter;
    private CartAdapter mAdapter;

    @BindView(R.id.cart_recylerview)
    RecyclerView mRecyclerView;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = super.onCreateView(inflater, container, savedInstanceState);

        // setup adapter
        mAdapter = new CartAdapter(new ArrayList<BookV0>());

        // setup recyclerview
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        mRecyclerView.setAdapter(mAdapter);

        // create MVP with configurator
        mConfigurator = new CartMVPConfigurator();
        mConfigurator.createMVPWithView(this);

        // request the cart information
        mPresenter.requestCart();

        return view;
    }

    @Override
    public int getViewId() {
        return R.layout.fragment_cart;
    }

    @Override
    public void attachPresenter(CartMVP.ProvidedPresenterOperations presenter) {
        mPresenter = presenter;
    }
}
