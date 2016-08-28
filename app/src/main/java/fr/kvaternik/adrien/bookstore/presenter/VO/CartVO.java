package fr.kvaternik.adrien.bookstore.presenter.VO;

import java.util.List;

/**
 * The cart visual object.
 */
public class CartVO {

    private List<BookV0> bookV0s;

    public CartVO(List<BookV0> bookV0s) {
        this.bookV0s = bookV0s;
    }

    public List<BookV0> getBookV0s() {
        return bookV0s;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CartVO cartVO = (CartVO) o;

        return bookV0s != null ? bookV0s.equals(cartVO.bookV0s) : cartVO.bookV0s == null;

    }

    @Override
    public int hashCode() {
        return bookV0s != null ? bookV0s.hashCode() : 0;
    }

    @Override
    public String toString() {
        return "CartVO{" +
                "bookV0s=" + bookV0s +
                '}';
    }
}
