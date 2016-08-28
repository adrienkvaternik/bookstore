package fr.kvaternik.adrien.bookstore.model.entity;

/**
 * A minus offer.
 */
public class MinusOffer extends Offer {

    public MinusOffer(double value) {
        super(value);
    }

    @Override
    public double getPriceAfterApplication(double totalPrice) {
        return Math.max(totalPrice - value, 0);
    }
}
