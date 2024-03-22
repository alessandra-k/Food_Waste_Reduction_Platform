package Model;

/**
 *
 * @author aless
 */
public enum FoodPreference {
    VEGAN(1),
    VEGETARIAN(2),
    GLUTEN_FREE(3),
    DAIRY_FREE(4),
    NUT_FREE(5),
    LACTOSE_FREE(6),
    HEALTH_CONSCIOUS(7),
    HALAL(8);

    private final int foodPreferences_id;

    FoodPreference(int id) {
        this.foodPreferences_id = id;
    }

    public int getFoodPreferences_id() {
        return foodPreferences_id;
    }


}
