package fr.kvaternik.adrien.bookstore.view.adapter;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import fr.kvaternik.adrien.bookstore.presenter.VO.BookVO;

import static org.junit.Assert.*;

/**
 * Tests for {@link BookListAdapter}.
 */
public class BookListAdapterShould {

    @Test
    public void have_an_item_count_equal_to_its_data_size() throws Exception {
        // data creation
        List<BookVO> bookVOs = new ArrayList<>();
        bookVOs.add(new BookVO("c8fabf68-8374-48fe-a7ea-a00ccd07afff", "Henri Potier à l'école des sorciers", "35,00", "http://henri-potier.xebia.fr/hp0.jpg", false));
        bookVOs.add(new BookVO("a460afed-e5e7-4e39-a39d-c885c05db861", "Henri Potier et la Chambre des secrets", "30,00", "http://henri-potier.xebia.fr/hp1.jpg", false));

        // action
        BookListAdapter bookListAdapter = new BookListAdapter(bookVOs, mListener);

        // assertion
        assertEquals("The item count is incorrect.", 2, bookListAdapter.getItemCount());
    }
}