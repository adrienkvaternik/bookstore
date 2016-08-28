package fr.kvaternik.adrien.bookstore.presenter.VO;

import java.util.List;

/**
 * The cart visual object.
 */
public class CartVO {

    private List<BookVO> bookVOs;
    private String totalPrice;

    public CartVO(List<BookVO> bookVOs, String totalPrice) {
        this.bookVOs = bookVOs;
        this.totalPrice = totalPrice;
    }

    public List<BookVO> getBookVOs() {
        return bookVOs;
    }

    public String getTotalPrice() {
        return totalPrice;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CartVO cartVO = (CartVO) o;

        if (bookVOs != null ? !bookVOs.equals(cartVO.bookVOs) : cartVO.bookVOs != null)
            return false;
        return totalPrice != null ? totalPrice.equals(cartVO.totalPrice) : cartVO.totalPrice == null;

    }

    @Override
    public int hashCode() {
        int result = bookVOs != null ? bookVOs.hashCode() : 0;
        result = 31 * result + (totalPrice != null ? totalPrice.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "CartVO{" +
                "bookVOs=" + bookVOs +
                ", totalPrice='" + totalPrice + '\'' +
                '}';
    }
}
