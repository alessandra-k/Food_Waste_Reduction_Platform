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

    public Subscription() {
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

    public List<FoodPreference> getFoodPreferences() {
        return foodPreferences;
    }

    public void addFoodPreference(FoodPreference preference) {
            if (foodPreferences == null) {
        foodPreferences = new ArrayList<>();
    }
        foodPreferences.add(preference);
    }

}
