package fr.kvaternik.adrien.bookstore.view.fragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import fr.kvaternik.adrien.bookstore.R;
import fr.kvaternik.adrien.bookstore.mvpconfigurator.BookListMVPConfigurator;
import fr.kvaternik.adrien.bookstore.mvpcontract.BookListMVP;
import fr.kvaternik.adrien.bookstore.presenter.VO.BookVO;
import fr.kvaternik.adrien.bookstore.view.adapter.BookListAdapter;

/**
 * The fragment used to display the book list.
 */
public class BookListFragment extends BaseFragment implements BookListMVP.RequiredViewOperations {

    private BookListMVPConfigurator mConfigurator;
    private BookListMVP.ProvidedPresenterOperations mPresenter;
    private BookListAdapter mAdapter;

    @BindView(R.id.book_list_recylerview)
    RecyclerView mRecyclerView;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = super.onCreateView(inflater, container, savedInstanceState);

        // setup adapter
        mAdapter = new BookListAdapter(new ArrayList<BookVO>());

        // setup recyclerview
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        mRecyclerView.setAdapter(mAdapter);

        // create MVP with configurator
        mConfigurator = new BookListMVPConfigurator();
        mConfigurator.createMVPWithView(this);

        // request books to presenter
        mPresenter.requestBooks();

        return view;
    }

    @Override
    public int getViewId() {
        return R.layout.fragment_book_list;
    }

    @Override
    public void onDestroy() {
        // destroy MVP with configurator
        mConfigurator.destroyMVPWithPresenter(mPresenter);
        super.onDestroy();
    }

    @Override
    public void attachPresenter(BookListMVP.ProvidedPresenterOperations presenter) {
        mPresenter = presenter;
    }

    @Override
    public void updateBookList(@NonNull List<BookVO> bookVOs) {
        mAdapter.updateData(bookVOs);
    }
}
