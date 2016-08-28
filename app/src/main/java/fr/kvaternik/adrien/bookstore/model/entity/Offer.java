package fr.kvaternik.adrien.bookstore.model.entity;

/**
 * The class representation of an offer.
 */
public abstract class Offer {

    protected double value;

    /**
     * Provides the price after the offer application on the specified total price.
     * @param totalPrice the total price.
     * @return The price after the offer application.
     */
    public abstract double getPriceAfterApplication(double totalPrice);

    public Offer(double value) {
        this.value = value;
    }
}
