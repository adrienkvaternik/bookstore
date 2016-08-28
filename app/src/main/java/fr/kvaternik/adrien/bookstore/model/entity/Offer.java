package fr.kvaternik.adrien.bookstore.model.entity;

/**
 * The class representation of an offer.
 */
public abstract class Offer {

    // constants for the offer unit
    public static final int UNIT_EUROS   = 1;
    public static final int UNIT_PERCENT = 2;

    protected double value;

    /**
     * Provides the price after the offer application on the specified total price.
     * @param totalPrice the total price.
     * @return The reduced price.
     */
    public abstract double getReducedPrice(double totalPrice);

    /**
     * Provides the offer unit.
     * @return The offer unit.
     */
    public abstract int getUnit();

    public Offer(double value) {
        this.value = value;
    }

    public double getValue() {
        return value;
    }
}
