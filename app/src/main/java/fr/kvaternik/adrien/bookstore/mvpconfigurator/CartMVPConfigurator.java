package fr.kvaternik.adrien.bookstore.mvpconfigurator;

import android.support.annotation.NonNull;

import fr.kvaternik.adrien.bookstore.model.CartModel;
import fr.kvaternik.adrien.bookstore.model.calculation.OfferOptimizer;
import fr.kvaternik.adrien.bookstore.model.repository.FakeCartRepository;
import fr.kvaternik.adrien.bookstore.model.service.FakeOfferService;
import fr.kvaternik.adrien.bookstore.mvpcontract.CartMVP;
import fr.kvaternik.adrien.bookstore.presenter.CartPresenter;

/**
 * The configurator for the cart MVP.
 * Creates and deletes the links between the MVP components.
 */
public class CartMVPConfigurator {

    /**
     * Creates the MVP.
     * @param view the view participating in the MVP
     */
    public void createMVPWithView(@NonNull CartMVP.RequiredViewOperations view) {
        // create presenter
        CartPresenter presenter = new CartPresenter();

        // create model
        CartModel model = new CartModel();
        model.setRepository(new FakeCartRepository());
        model.setService(new FakeOfferService());
        model.setOfferOptimizer(new OfferOptimizer());

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
    public void destroyMVPWithPresenter(@NonNull CartMVP.ProvidedPresenterOperations presenter) {
        presenter.detachModel();
        presenter.detachView();
    }
}
