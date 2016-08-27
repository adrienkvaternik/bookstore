package fr.kvaternik.adrien.bookstore.view.fragment;

import fr.kvaternik.adrien.bookstore.R;
import fr.kvaternik.adrien.bookstore.mvpcontract.BookListMVP;

/**
 * The fragment used to display the book list.
 */
public class BookListFragment extends BaseFragment implements BookListMVP.RequiredViewOperations {

    @Override
    public int getViewId() {
        return R.layout.fragment_book_list;
    }
}
