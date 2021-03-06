package fr.kvaternik.adrien.bookstore.presenter.VO;

/**
 * The book visual object.
 */
public class BookVO {

    private String isbn;
    private String title;
    private String price;
    private String cover;
    private boolean addedToCart;

    public BookVO(String isbn, String title, String price, String cover, boolean addedToCart) {
        this.isbn = isbn;
        this.title = title;
        this.price = price;
        this.cover = cover;
        this.addedToCart = addedToCart;
    }

    public String getIsbn() {
        return isbn;
    }

    public String getTitle() {
        return title;
    }

    public String getPrice() {
        return price;
    }

    public String getCover() {
        return cover;
    }

    public boolean isAddedToCart() {
        return addedToCart;
    }

    public void setAddedToCart(boolean addedToCart) {
        this.addedToCart = addedToCart;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        BookVO bookVO = (BookVO) o;

        if (addedToCart != bookVO.addedToCart) return false;
        if (isbn != null ? !isbn.equals(bookVO.isbn) : bookVO.isbn != null) return false;
        if (title != null ? !title.equals(bookVO.title) : bookVO.title != null) return false;
        if (price != null ? !price.equals(bookVO.price) : bookVO.price != null) return false;
        return cover != null ? cover.equals(bookVO.cover) : bookVO.cover == null;

    }

    @Override
    public int hashCode() {
        int result = isbn != null ? isbn.hashCode() : 0;
        result = 31 * result + (title != null ? title.hashCode() : 0);
        result = 31 * result + (price != null ? price.hashCode() : 0);
        result = 31 * result + (cover != null ? cover.hashCode() : 0);
        result = 31 * result + (addedToCart ? 1 : 0);
        return result;
    }

    @Override
    public String toString() {
        return "BookVO{" +
                "isbn='" + isbn + '\'' +
                ", title='" + title + '\'' +
                ", price='" + price + '\'' +
                ", cover='" + cover + '\'' +
                ", addedToCart=" + addedToCart +
                '}';
    }
}
