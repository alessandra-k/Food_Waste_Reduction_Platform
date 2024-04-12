package DataAccessLayer;

import Model.Subscription;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.List;
import java.sql.SQLException;
import java.sql.ResultSet;

/**
 *
 * @author aless
 */
public class SubscriptionDAOImpl implements SubscriptionDAO {
//Peace Added this 
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
        public Subscription getSubscriptionByUserId(int user_id) {
            Connection connection = null;
            String sql = "SELECT * FROM Subscription WHERE user_id = ?";
            try {
                connection = DataSource.getConnection();
                try (PreparedStatement statement = connection.prepareStatement(sql)) {
                    statement.setInt(1, user_id);
                    try (ResultSet resultSet = statement.executeQuery()) {
                        if (resultSet.next()) {
                            // Create and populate a Subscription object
                            Subscription subscription = new Subscription();
                            subscription.setSubscription_id(resultSet.getInt("subscription_id"));
                            subscription.setNeighbourhood_id(resultSet.getInt("neighbourhood_id"));
                            subscription.setCommunicationMethod_id(resultSet.getInt("communicationMethod_id"));
                            subscription.setFoodPreferences_id(resultSet.getInt("foodPreferences_id"));
                            subscription.setUser_id(resultSet.getInt("user_id"));
                            // Populate food preferences if needed
                            return subscription;
                        } else {
                            // No subscription found for the given user ID
                            return null;
                        }
                    }
                }
            } catch (SQLException e) {
                // Handle any SQL errors
                e.printStackTrace();
                return null;
            } finally {
                // Close the connection in the finally block
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
    public void deleteSubscriptionByUserId(int userId) {
        Connection connection = null;
        PreparedStatement statement = null;
        String sql = "DELETE FROM Subscription WHERE user_id = ?";
        try {
            // Get a database connection
            connection = DataSource.getConnection();
            // Create a PreparedStatement with the SQL query
            statement = connection.prepareStatement(sql);
            // Set user ID as parameter
            statement.setInt(1, userId);
            // Execute the query
            statement.executeUpdate();
        } catch (SQLException e) {
            // Handle any SQL errors
            e.printStackTrace();
        } finally {
            // Close the resources
            // ...
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
