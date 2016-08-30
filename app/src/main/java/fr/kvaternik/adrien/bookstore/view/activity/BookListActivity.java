package fr.kvaternik.adrien.bookstore.view.activity;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuItem;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import fr.kvaternik.adrien.bookstore.R;
import fr.kvaternik.adrien.bookstore.mvpconfigurator.BookListMVPConfigurator;
import fr.kvaternik.adrien.bookstore.mvpcontract.BookListMVP;
import fr.kvaternik.adrien.bookstore.presenter.VO.BookVO;
import fr.kvaternik.adrien.bookstore.router.BookListRouter;
import fr.kvaternik.adrien.bookstore.router.BookListRouterContract;
import fr.kvaternik.adrien.bookstore.view.adapter.BookListAdapter;
import fr.kvaternik.adrien.bookstore.view.listener.OnBookAddedToCartChangeListener;

/**
 * The book list activity.
 */
public class BookListActivity extends BaseActivity implements BookListMVP.RequiredViewOperations, OnBookAddedToCartChangeListener {

    private BookListMVPConfigurator mConfigurator;
    private BookListMVP.ProvidedPresenterOperations mPresenter;
    private BookListAdapter mAdapter;
    private BookListRouterContract mRouter;

    @BindView(R.id.book_list_recylerview)
    RecyclerView mRecyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // setup adapter
        mAdapter = new BookListAdapter(new ArrayList<BookVO>(), this);

        // setup recyclerview
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        mRecyclerView.setAdapter(mAdapter);

        // create MVP with configurator
        mConfigurator = new BookListMVPConfigurator();
        mConfigurator.createMVPWithView(this);

        // create router
        mRouter = new BookListRouter();

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
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_book_list, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == R.id.menu_cart) {
            mRouter.navigateToCart(this);
            return true;
        } else {
            return super.onOptionsItemSelected(item);
        }
    }

    @Override
    protected int getContentViewId() {
        return R.layout.activity_book_list;
    }

    @NonNull
    @Override
    protected String getActivityTitle() {
        return getString(R.string.title_library);
    }

    @Override
    public void attachPresenter(BookListMVP.ProvidedPresenterOperations presenter) {
        mPresenter = presenter;
    }

    @Override
    public void showBooks(@NonNull List<BookVO> bookVOs) {
        mAdapter.updateData(bookVOs);
    }

    @Override
    public void showEmptyBookList() {
        // TODO : impl
    }

    @Override
    public void showError() {
        // TODO : impl
    }

    @Override
    public void onBookAddedToCart(String isbn) {
        mPresenter.onBookAddedToCart(isbn);
    }

    @Override
    public void onBookRemovedFromCart(String isbn) {
        mPresenter.onBookRemovedFromCart(isbn);
    }
}
