package fr.kvaternik.adrien.bookstore.view.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import fr.kvaternik.adrien.bookstore.R;
import fr.kvaternik.adrien.bookstore.model.BookListModel;
import fr.kvaternik.adrien.bookstore.mvpcontract.BookListMVP;
import fr.kvaternik.adrien.bookstore.presenter.BookListPresenter;

/**
 * The fragment used to display the book list.
 */
public class BookListFragment extends BaseFragment implements BookListMVP.RequiredViewOperations {

    private BookListMVP.ProvidedPresenterOperations<BookListMVP.RequiredViewOperations, BookListMVP.ProvidedModelOperations> mPresenter;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = super.onCreateView(inflater, container, savedInstanceState);

        createMVP();

        return view;
    }

    @Override
    public int getViewId() {
        return R.layout.fragment_book_list;
    }

    @Override
    public void onDestroy() {
        destroyMVP();
        super.onDestroy();
    }

    /**
     * Creates the MVP.
     */
    private void createMVP() {
        BookListPresenter presenter = new BookListPresenter();

        mPresenter = presenter;
        mPresenter.attachView(this);

        BookListMVP.ProvidedModelOperations<BookListMVP.RequiredPresenterOperations> model = new BookListModel();

        mPresenter.attachModel(model);
        model.attachPresenter(presenter);
    }

    /**
     * Destroys the MVP.
     */
    private void destroyMVP() {
        mPresenter.detachModel();
        mPresenter.detachView();
    }
}
