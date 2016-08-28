package fr.kvaternik.adrien.bookstore.model.entity;

/**
 * A slice offer.
 */
public class SliceOffer extends Offer {

    private double sliceValue;

    public SliceOffer(double value, double sliceValue) {
        super(value, UNIT_EUROS);
        this.sliceValue = sliceValue;
    }

    @Override
    public double getPriceAfterApplication(double totalPrice) {
        int quotient = (int) (totalPrice / sliceValue);
        return Math.max(totalPrice - value * quotient, 0);
    }
}
