package fr.kvaternik.adrien.bookstore.model.entity;

/**
 * A slice offer.
 */
public class SliceOffer extends Offer {

    private double sliceValue;

    public SliceOffer(double value, double sliceValue) {
        super(value);
        this.sliceValue = sliceValue;
    }

    @Override
    public double getReducedPrice(double totalPrice) {
        int quotient = (int) (totalPrice / sliceValue);
        return Math.max(totalPrice - value * quotient, 0);
    }

    @Override
    public int getUnit() {
        return UNIT_EUROS;
    }
}
