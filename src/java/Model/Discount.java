package Model;

/**
 *
 * @author aless
 */
public enum Discount {

    NO_DISCOUNT(1, 0.0, " "),
    TEN_PERCENT(2, 0.10, "10%"),
    TWENTY_PERCENT(3, 0.20, "20%"),
    THIRTY_PERCENT(4, 0.30, "30%"),
    FORTY_PERCENT(5, 0.40, "40%"),
    FIFTY_PERCENT(6, 0.50, "50%");

    private final int discount_id;
    private final double rate;
        private final String description;

    Discount(int id, double rate,String description) {
        this.discount_id = id;
        this.rate = rate;
         this.description = description;
    }

    public int getDiscount_id() {
        return discount_id;
    }

    public double getRate() {
        return rate;
    }
    
        public String getDescription() {
        return description;
    }
    
    public static String getDiscountDescriptionById(int id) {
    for (Discount discount : Discount.values()) {
        if (discount.getDiscount_id() == id) {
            return discount.description;
        }
    }
    return null; // Return null if no matching discount is found
}

    
   }
