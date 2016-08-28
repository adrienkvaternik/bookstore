package fr.kvaternik.adrien.bookstore.presenter.VO;

/**
 * The offer visual object.
 */
public class OfferVO {

    private String offerValue;
    private String reducedPrice;

    public OfferVO(String offerValue, String reducedPrice) {
        this.offerValue = offerValue;
        this.reducedPrice = reducedPrice;
    }

    public String getOfferValue() {
        return offerValue;
    }

    public String getReducedPrice() {
        return reducedPrice;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        OfferVO offerVO = (OfferVO) o;

        if (offerValue != null ? !offerValue.equals(offerVO.offerValue) : offerVO.offerValue != null)
            return false;
        return reducedPrice != null ? reducedPrice.equals(offerVO.reducedPrice) : offerVO.reducedPrice == null;

    }

    @Override
    public int hashCode() {
        int result = offerValue != null ? offerValue.hashCode() : 0;
        result = 31 * result + (reducedPrice != null ? reducedPrice.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "OfferVO{" +
                "offerValue='" + offerValue + '\'' +
                ", reducedPrice='" + reducedPrice + '\'' +
                '}';
    }
}
