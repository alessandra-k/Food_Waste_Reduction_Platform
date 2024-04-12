package Model;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 * @author aless
 */
public class Subscription {

    private int subscription_id;
    private int neighbourhood_id;
    private  int communicationMethod_id;
    private int user_id;
    private List<FoodPreference> foodPreferences;
    private int foodPreferences_id;

    public Subscription() {
        this.foodPreferences = new ArrayList<>();
    }

    public int getSubscription_id() {
        return subscription_id;
    }

    public void setSubscription_id(int subscription_id) {
        this.subscription_id = subscription_id;
    }

    public int getNeighbourhood_id() {
        return neighbourhood_id;
    }

    public void setNeighbourhood_id(int neighbourhood_id) {
        this.neighbourhood_id = neighbourhood_id;
    }

    public int getCommunicationMethod_id() {
        return communicationMethod_id;
    }

    public void setCommunicationMethod_id(int communicationMethod_id) {
        this.communicationMethod_id = communicationMethod_id;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }
    
    
     public int getFoodPreferences_id() {
        return foodPreferences_id;
    }

    public void setFoodPreferences_id(int foodPreferences_id) {
        this.foodPreferences_id = foodPreferences_id;
    }


    public List<FoodPreference> getFoodPreferences() {
        return foodPreferences;
    }

    public void addFoodPreference(FoodPreference preference) {
            if (foodPreferences == null) {
        foodPreferences = new ArrayList<>();
    }
        foodPreferences.add(preference);
         
      
    }
    //Peace Added this 
    
    public void setFoodPreferences(List<String> foodPreferences) {
     this.foodPreferences = new ArrayList<>();
        int combinedId = 0;
        for (String preference : foodPreferences) {
            switch (preference) {
                case "1":
                    this.foodPreferences.add(FoodPreference.VEGAN);
                    combinedId += FoodPreference.VEGAN.getFoodPreferences_id();
                    break;
                case "2":
                    this.foodPreferences.add(FoodPreference.VEGETARIAN);
                    combinedId += FoodPreference.VEGETARIAN.getFoodPreferences_id();
                    break;
                case "3":
                    this.foodPreferences.add(FoodPreference.GLUTEN_FREE);
                    combinedId += FoodPreference.GLUTEN_FREE.getFoodPreferences_id();
                    break;
                case "4":
                    this.foodPreferences.add(FoodPreference.DAIRY_FREE);
                    combinedId += FoodPreference.DAIRY_FREE.getFoodPreferences_id();
                    break;
                case "5":
                    this.foodPreferences.add(FoodPreference.NUT_FREE);
                    combinedId += FoodPreference.NUT_FREE.getFoodPreferences_id();
                    break;
                case "6":
                    this.foodPreferences.add(FoodPreference.LACTOSE_FREE);
                    combinedId += FoodPreference.LACTOSE_FREE.getFoodPreferences_id();
                    break;
                case "7":
                    this.foodPreferences.add(FoodPreference.HEALTH_CONSCIOUS);
                    combinedId += FoodPreference.HEALTH_CONSCIOUS.getFoodPreferences_id();
                    break;
                case "8":
                    this.foodPreferences.add(FoodPreference.HALAL);
                    combinedId += FoodPreference.HALAL.getFoodPreferences_id();
                    break;
                default:
                    // Handle unknown preferences or throw an exception
                    throw new IllegalArgumentException("Unknown food preference: " + preference);
            }
        }
        this.foodPreferences_id = combinedId;
            }
        }




