package fr.kvaternik.adrien.bookstore.mvpconfigurator;

import android.support.annotation.NonNull;

import fr.kvaternik.adrien.bookstore.model.BookListModel;
import fr.kvaternik.adrien.bookstore.model.FakeBookListModel;
import fr.kvaternik.adrien.bookstore.mvpcontract.BookListMVP;
import fr.kvaternik.adrien.bookstore.presenter.BookListPresenter;

/**
 * The configurator for the book list MVP.
 * Creates and deletes the links between the MVP components.
 */
public class BookListMVPConfigurator {

    /**
     * Creates the MVP.
     * @param view the view participating in the MVP
     */
    public void createMVPWithView(@NonNull BookListMVP.RequiredViewOperations view) {
        BookListPresenter presenter = new BookListPresenter();

        // TODO : use real model
        //BookListModel model = new BookListModel();
        FakeBookListModel model = new FakeBookListModel();

        view.attachPresenter(presenter);
        presenter.attachView(view);

        presenter.attachModel(model);
        model.attachPresenter(presenter);
    }

    /**
     * Destroys the MVP.
     * @param presenter the presenter participating in the MVP
     */
    public void destroyMVPWithPresenter(@NonNull BookListMVP.ProvidedPresenterOperations presenter) {
        presenter.detachModel();
        presenter.detachView();
    }
}
