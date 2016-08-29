package fr.kvaternik.adrien.bookstore.view.listener;

/**
 * The listener used when a book is added/removed from the cart.
 */
public interface OnBookAddedToCartChangeListener {

    /**
     * Used when the book is added to the cart.
     * @param isbn the book isbn
     */
    void onBookAddedToCart(String isbn);

    /**
     * Used when the book is removed from the cart.
     * @param isbn the book isbn
     */
    void onBookRemovedFromCart(String isbn);
}
