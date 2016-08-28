package fr.kvaternik.adrien.bookstore.view.adapter;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import fr.kvaternik.adrien.bookstore.presenter.VO.BookV0;

import static org.junit.Assert.*;

/**
 * Tests for {@link CartAdapter}.
 */
public class CartAdapterShould {

    @Test
    public void have_an_item_count_equal_to_its_data_size() throws Exception {
        // data creation
        List<BookV0> bookV0s = new ArrayList<>();
        bookV0s.add(new BookV0("c8fabf68-8374-48fe-a7ea-a00ccd07afff", "Henri Potier à l'école des sorciers", "35,00", "http://henri-potier.xebia.fr/hp0.jpg"));
        bookV0s.add(new BookV0("a460afed-e5e7-4e39-a39d-c885c05db861", "Henri Potier et la Chambre des secrets", "30,00", "http://henri-potier.xebia.fr/hp1.jpg"));

        // action
        CartAdapter cartAdapter = new CartAdapter(bookV0s);

        // assertion
        assertEquals("The item count is incorrect.", 2, cartAdapter.getItemCount());
    }
}