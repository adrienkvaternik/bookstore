package fr.kvaternik.adrien.bookstore.model.entity;

/**
 * The class representation of an offer.
 */
public abstract class Offer {

    // constants for the offer unit
    public static final int UNIT_EUROS   = 1;
    public static final int UNIT_PERCENT = 2;

    protected double value;
    protected int unit;

    /**
     * Provides the price after the offer application on the specified total price.
     * @param totalPrice the total price.
     * @return The reduced price.
     */
    public abstract double getReducedPrice(double totalPrice);

    public Offer(double value, int unit) {
        this.value = value;
        this.unit = unit;
    }

    public double getValue() {
        return value;
    }

    public int getUnit() {
        return unit;
    }
}
