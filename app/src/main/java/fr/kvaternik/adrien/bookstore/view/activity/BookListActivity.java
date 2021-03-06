package fr.kvaternik.adrien.bookstore.view.activity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

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
public class BookListActivity extends RefreshableActivity implements BookListMVP.RequiredViewOperations, OnBookAddedToCartChangeListener {

    private BookListMVPConfigurator mConfigurator;
    private BookListMVP.ProvidedPresenterOperations mPresenter;
    private BookListAdapter mAdapter;
    private BookListRouterContract mRouter;

    @BindView(R.id.no_book_view)
    View mNoBookView;

    @BindView(R.id.book_list_recylerview)
    RecyclerView mRecyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // display no book layout
        displayNoBookLayout();

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
        requestBooks();
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

    @Override
    protected void onSwipeRefresh() {
        requestBooks();
    }

    @Override
    public void attachPresenter(BookListMVP.ProvidedPresenterOperations presenter) {
        mPresenter = presenter;
    }

    @Override
    public void showBooks(@NonNull List<BookVO> bookVOs) {
        hideRefreshIndicator();
        displayBookListLayout();
        mAdapter.updateData(bookVOs);
    }

    @Override
    public void showNoBook() {
        hideRefreshIndicator();
        displayNoBookLayout();
        mAdapter.updateData(new ArrayList<BookVO>());
    }

    @Override
    public void showError() {
        hideRefreshIndicator();
        new AlertDialog.Builder(this)
                .setTitle(R.string.error_title)
                .setMessage(R.string.error_message_books)
                .setPositiveButton(R.string.yes, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        // User accepts retry
                        requestBooks();
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

    @Override
    public void onBookAddedToCart(String isbn) {
        mPresenter.onBookAddedToCart(isbn);
    }

    @Override
    public void onBookRemovedFromCart(String isbn) {
        mPresenter.onBookRemovedFromCart(isbn);
    }

    /**
     * Requests the books.
     */
    private void requestBooks() {
        showRefreshIndicator();
        mPresenter.requestBooks();
    }

    /**
     * Displays the book list layout.
     */
    private void displayBookListLayout() {
        mNoBookView.setVisibility(View.GONE);
        mRecyclerView.setVisibility(View.VISIBLE);
    }

    /**
     * Displays the no book layout.
     */
    private void displayNoBookLayout() {
        mRecyclerView.setVisibility(View.GONE);
        mNoBookView.setVisibility(View.VISIBLE);
    }
}
