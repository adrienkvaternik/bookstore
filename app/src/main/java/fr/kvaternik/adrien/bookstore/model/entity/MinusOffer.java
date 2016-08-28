package fr.kvaternik.adrien.bookstore.model.entity;

/**
 * A minus offer.
 */
public class MinusOffer extends Offer {

    public MinusOffer(double value) {
        super(value);
    }

    @Override
    public double getReducedPrice(double totalPrice) {
        return Math.max(totalPrice - value, 0);
    }

    @Override
    public int getUnit() {
        return UNIT_EUROS;
    }
}
