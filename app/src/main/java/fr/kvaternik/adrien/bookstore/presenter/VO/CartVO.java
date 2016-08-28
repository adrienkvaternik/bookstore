package fr.kvaternik.adrien.bookstore.presenter.VO;

import java.util.List;

/**
 * The cart visual object.
 */
public class CartVO {

    private List<BookV0> bookV0s;
    private String totalPrice;

    public CartVO(List<BookV0> bookV0s, String totalPrice) {
        this.bookV0s = bookV0s;
        this.totalPrice = totalPrice;
    }

    public List<BookV0> getBookV0s() {
        return bookV0s;
    }

    public String getTotalPrice() {
        return totalPrice;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CartVO cartVO = (CartVO) o;

        if (bookV0s != null ? !bookV0s.equals(cartVO.bookV0s) : cartVO.bookV0s != null)
            return false;
        return totalPrice != null ? totalPrice.equals(cartVO.totalPrice) : cartVO.totalPrice == null;

    }

    @Override
    public int hashCode() {
        int result = bookV0s != null ? bookV0s.hashCode() : 0;
        result = 31 * result + (totalPrice != null ? totalPrice.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "CartVO{" +
                "bookV0s=" + bookV0s +
                ", totalPrice='" + totalPrice + '\'' +
                '}';
    }
}
