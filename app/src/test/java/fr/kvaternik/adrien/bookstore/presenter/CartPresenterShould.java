package fr.kvaternik.adrien.bookstore.presenter;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import fr.kvaternik.adrien.bookstore.mvpcontract.CartMVP;

import static org.mockito.Mockito.*;

/**
 * Tests for {@link BookListPresenter}.
 */
@RunWith(MockitoJUnitRunner.class)
public class CartPresenterShould {

    private CartPresenter mPresenter;

    @Mock
    private CartMVP.ProvidedModelOperations mMockModel;

    @Before
    public void setUp() throws Exception {
        mPresenter = new CartPresenter();
        mPresenter.attachModel(mMockModel);
    }

    @Test
    public void call_its_model_on_cart_request() throws Exception {
        // action
        mPresenter.requestCart();

        // assertion
        verify(mMockModel).getCart();
    }
}