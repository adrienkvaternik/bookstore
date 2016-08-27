package fr.kvaternik.adrien.bookstore.presenter.VO;

/**
 * The book visual object.
 */
public class BookV0 {

    private String isbn;
    private String title;
    private String price;
    private String cover;

    public BookV0(String isbn, String title, String price, String cover) {
        this.isbn = isbn;
        this.title = title;
        this.price = price;
        this.cover = cover;
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

    @Override
    public String toString() {
        return "BookV0{" +
                "isbn='" + isbn + '\'' +
                ", title='" + title + '\'' +
                ", price='" + price + '\'' +
                ", cover='" + cover + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        BookV0 bookV0 = (BookV0) o;

        if (isbn != null ? !isbn.equals(bookV0.isbn) : bookV0.isbn != null) return false;
        if (title != null ? !title.equals(bookV0.title) : bookV0.title != null) return false;
        if (price != null ? !price.equals(bookV0.price) : bookV0.price != null) return false;
        return cover != null ? cover.equals(bookV0.cover) : bookV0.cover == null;

    }

    @Override
    public int hashCode() {
        int result = isbn != null ? isbn.hashCode() : 0;
        result = 31 * result + (title != null ? title.hashCode() : 0);
        result = 31 * result + (price != null ? price.hashCode() : 0);
        result = 31 * result + (cover != null ? cover.hashCode() : 0);
        return result;
    }
}
