package DataAccessLayer;

import Model.Subscription;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.List;
import java.sql.SQLException;

/**
 *
 * @author aless
 */
public class SubscriptionDAOImpl implements SubscriptionDAO {

    @Override
    public void addSubscription(Subscription subscription) {
        Connection connection = null;
        PreparedStatement statement = null;
       String sql = "INSERT INTO Subscription (neighbourhood_id, communicationMethod_id, foodPreferences_id, user_id) VALUES (?, ?, ?, ?)";
        
        try {
        // Get a database connection
        connection = DataSource.getConnection();
        
        // Create a PreparedStatement with the SQL query
        statement = connection.prepareStatement(sql);
        
        // Set values for the parameters
        statement.setInt(1, subscription.getNeighbourhood_id());
        statement.setInt(2, subscription.getCommunicationMethod_id());
        statement.setInt(3, subscription.getFoodPreferences_id());
        statement.setInt(4, subscription.getUser_id());
        
        // Execute the query
        statement.executeUpdate();
    } catch (SQLException e) {
        // Handle any SQL errors
        e.printStackTrace();
    } finally {
        // Close the PreparedStatement and the connection
        if (statement != null) {
            try {
                statement.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if (connection != null) {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
    }

    @Override
    public Subscription getSubscriptionById(int subscriptionId) {
        return null;
    }

    @Override
    public List<Subscription> getAllSubscriptions() {
        return null;
    }

    @Override
    public void updateSubscription(int subscriptionId) {

    }

    @Override
    public void deleteSubscription(int subscriptionId) {

    }

}
