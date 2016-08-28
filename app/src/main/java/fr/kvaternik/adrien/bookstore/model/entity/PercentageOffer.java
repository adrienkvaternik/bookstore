package fr.kvaternik.adrien.bookstore.model.entity;

/**
 * A percentage offer.
 */
public class PercentageOffer extends Offer {

    public PercentageOffer(double value) {
        super(value, UNIT_PERCENT);
    }

    @Override
    public double getPriceAfterApplication(double totalPrice) {
        return Math.max(totalPrice * (1 - value/100.0), 0);
    }
}
