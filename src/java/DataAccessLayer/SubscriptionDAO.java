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

    List<Subscription> getAllSubscriptions();

    void updateSubscription(int subscriptionId);

    void deleteSubscription(int subscriptionId);
}
