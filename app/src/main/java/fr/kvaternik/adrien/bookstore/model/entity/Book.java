package fr.kvaternik.adrien.bookstore.model.entity;

/**
 * The class representation of a book.
 */
public class Book {

    private String isbn;
    private String title;
    private double price;
    private String cover;

    public Book(String isbn, String title, double price, String cover) {
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

    public double getPrice() {
        return price;
    }

    public String getCover() {
        return cover;
    }
}
