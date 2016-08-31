package fr.kvaternik.adrien.bookstore.model.mapper;

import org.junit.Test;

import fr.kvaternik.adrien.bookstore.model.entity.Book;
import fr.kvaternik.adrien.bookstore.presenter.VO.BookVO;
import fr.kvaternik.adrien.bookstore.utils.DecimalFormatUtils;

import static org.junit.Assert.*;

/**
 * Tests for {@link BookToBookVOMapper].
 */
public class BookToBookVOMapperShould {

    // constants
    private static final String ISBN = "c8fabf68-8374-48fe-a7ea-a00ccd07afff";
    private static final String TITLE = "Henri Potier à l'école des sorciers";
    private static final String COVER = "http://henri-potier.xebia.fr/hp0.jpg";
    private static final double PRICE = 35.0;
    private static final String PRICE_STRING = "35,00 €";

    @Test
    public void map_a_book_in_cart_into_a_book_vo_in_cart() throws Exception {
        BookToBookVOMapper mapper = new BookToBookVOMapper(DecimalFormatUtils.decimalFormatEuros(), true);

        // data creation
        Book book = new Book(ISBN, TITLE, PRICE, COVER);
        BookVO expectedBookVO = new BookVO(ISBN, TITLE, PRICE_STRING, COVER, true);

        // assertion
        assertEquals(expectedBookVO, mapper.map(book));
    }

    @Test
    public void map_a_book_not_in_cart_into_a_book_vo_not_in_cart() throws Exception {
        BookToBookVOMapper mapper = new BookToBookVOMapper(DecimalFormatUtils.decimalFormatEuros(), false);

        // data creation
        Book book = new Book(ISBN, TITLE, PRICE, COVER);
        BookVO expectedBookVO = new BookVO(ISBN, TITLE, PRICE_STRING, COVER, false);

        // assertion
        assertEquals(expectedBookVO, mapper.map(book));
    }
}