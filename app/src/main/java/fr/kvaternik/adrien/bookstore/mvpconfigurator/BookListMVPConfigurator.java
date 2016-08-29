package fr.kvaternik.adrien.bookstore.mvpconfigurator;

import android.support.annotation.NonNull;

import fr.kvaternik.adrien.bookstore.model.BookListModel;
import fr.kvaternik.adrien.bookstore.model.repository.FakeBookRepository;
import fr.kvaternik.adrien.bookstore.model.service.API.provider.RetrofitAPIProvider;
import fr.kvaternik.adrien.bookstore.model.service.BookService;
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
        // create presenter
        BookListPresenter presenter = new BookListPresenter();

        // create model
        BookListModel model = new BookListModel();
        BookService service = new BookService();
        service.setAPIProvider(RetrofitAPIProvider.getInstance());
        model.setService(service);
        // TODO : use real book repository
        model.setRepository(new FakeBookRepository());

        // V -> P
        view.attachPresenter(presenter);
        // P -> V
        presenter.attachView(view);
        // P -> M
        presenter.attachModel(model);
        // M -> P
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
