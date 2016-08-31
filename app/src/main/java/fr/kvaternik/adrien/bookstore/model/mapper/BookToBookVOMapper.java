package fr.kvaternik.adrien.bookstore.model.mapper;

import android.support.annotation.NonNull;

import java.text.DecimalFormat;

import fr.kvaternik.adrien.bookstore.model.entity.Book;
import fr.kvaternik.adrien.bookstore.presenter.VO.BookVO;

/**
 * A mapper that maps a {@link Book} into a {@link BookVO}.
 */
public class BookToBookVOMapper implements Mapper<Book, BookVO> {

    private DecimalFormat mDecimalFormat;
    private boolean inCart;

    public BookToBookVOMapper(@NonNull DecimalFormat decimalFormat, boolean inCart) {
        mDecimalFormat = decimalFormat;
        this.inCart = inCart;
    }

    @NonNull
    @Override
    public BookVO map(@NonNull Book book) {
        return new BookVO(
                book.getIsbn(),
                book.getTitle(),
                mDecimalFormat.format(book.getPrice()),
                book.getCover(),
                inCart
        );
    }
}
