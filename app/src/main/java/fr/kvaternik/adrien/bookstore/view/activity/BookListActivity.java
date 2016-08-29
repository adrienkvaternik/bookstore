package fr.kvaternik.adrien.bookstore.view.activity;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import fr.kvaternik.adrien.bookstore.R;
import fr.kvaternik.adrien.bookstore.mvpconfigurator.BookListMVPConfigurator;
import fr.kvaternik.adrien.bookstore.mvpcontract.BookListMVP;
import fr.kvaternik.adrien.bookstore.presenter.VO.BookVO;
import fr.kvaternik.adrien.bookstore.view.adapter.BookListAdapter;

/**
 * The book list activity.
 */
public class BookListActivity extends BaseActivity implements BookListMVP.RequiredViewOperations {

    private BookListMVPConfigurator mConfigurator;
    private BookListMVP.ProvidedPresenterOperations mPresenter;
    private BookListAdapter mAdapter;

    @BindView(R.id.book_list_recylerview)
    RecyclerView mRecyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // setup adapter
        mAdapter = new BookListAdapter(new ArrayList<BookVO>());

        // setup recyclerview
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        mRecyclerView.setAdapter(mAdapter);

        // create MVP with configurator
        mConfigurator = new BookListMVPConfigurator();
        mConfigurator.createMVPWithView(this);

        // request books to presenter
        mPresenter.requestBooks();
    }

    @Override
    public void onDestroy() {
        // destroy MVP with configurator
        mConfigurator.destroyMVPWithPresenter(mPresenter);
        super.onDestroy();
    }

    @Override
    protected int getContentViewId() {
        return R.layout.activity_book_list;
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
