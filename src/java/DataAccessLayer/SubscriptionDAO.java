package DataAccessLayer;

import Model.Subscription;
import java.util.List;

/**
 *
 * @author aless
 */
public interface SubscriptionDAO {

    void addSubscription(Subscription subscription);

    Subscription getSubscriptionById(int subscriptionId);

    Subscription getSubscriptionByUserId(int user_id);

    void deleteSubscriptionByUserId(int user_id);

    List<Subscription> getAllSubscriptions();

    void updateSubscription(int subscriptionId);

    //Peace Added this
    void deleteSubscription(int subscriptionId);

}
