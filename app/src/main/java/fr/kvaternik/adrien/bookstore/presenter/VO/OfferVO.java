package fr.kvaternik.adrien.bookstore.presenter.VO;

/**
 * The offer visual object.
 */
public class OfferVO {

    private String offerValue;
    private String reductedPrice;

    public OfferVO(String offerValue, String reductedPrice) {
        this.offerValue = offerValue;
        this.reductedPrice = reductedPrice;
    }

    public String getOfferValue() {
        return offerValue;
    }

    public String getReductedPrice() {
        return reductedPrice;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        OfferVO offerVO = (OfferVO) o;

        if (offerValue != null ? !offerValue.equals(offerVO.offerValue) : offerVO.offerValue != null)
            return false;
        return reductedPrice != null ? reductedPrice.equals(offerVO.reductedPrice) : offerVO.reductedPrice == null;

    }

    @Override
    public int hashCode() {
        int result = offerValue != null ? offerValue.hashCode() : 0;
        result = 31 * result + (reductedPrice != null ? reductedPrice.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "OfferVO{" +
                "offerValue='" + offerValue + '\'' +
                ", reductedPrice='" + reductedPrice + '\'' +
                '}';
    }
}
