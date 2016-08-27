package fr.kvaternik.adrien.bookstore.view.fragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

import fr.kvaternik.adrien.bookstore.R;
import fr.kvaternik.adrien.bookstore.mvpconfigurator.BookListMVPConfigurator;
import fr.kvaternik.adrien.bookstore.mvpcontract.BookListMVP;
import fr.kvaternik.adrien.bookstore.presenter.VO.BookV0;

/**
 * The fragment used to display the book list.
 */
public class BookListFragment extends BaseFragment implements BookListMVP.RequiredViewOperations {

    private BookListMVPConfigurator mConfigurator;
    private BookListMVP.ProvidedPresenterOperations mPresenter;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = super.onCreateView(inflater, container, savedInstanceState);

        // create MVP with configurator
        mConfigurator = new BookListMVPConfigurator();
        mConfigurator.createMVPWithView(this);

        mPresenter.requestBooks();

        return view;
    }

    @Override
    public int getViewId() {
        return R.layout.fragment_book_list;
    }

    @Override
    public void onDestroy() {
        // destroy MVP
        mConfigurator.destroyMVPWithPresenter(mPresenter);
        super.onDestroy();
    }

    @Override
    public void attachPresenter(BookListMVP.ProvidedPresenterOperations presenter) {
        mPresenter = presenter;
    }

    @Override
    public void updateBookList(@NonNull List<BookV0> bookVOs) {
        // TODO : impl
    }
}
