package DataAccessLayer;

import static DataAccessLayer.DataSource.closeConnectionAndResources;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author aless
 */
public class SurplusItemsDAOImpl implements SurplusItemsDAO {

    @Override
    public void updateItemDiscount(int itemId, int discountId) {
        Connection connection = null;
        PreparedStatement statement = null;
        String sqlQuery = "UPDATE Item SET discount_id = ? WHERE item_id = ?";
        try {
            connection = DataSource.getConnection();
            statement = connection.prepareStatement(sqlQuery);

            statement.setInt(1, discountId);
            statement.setInt(2, itemId);

            // Execute the update
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeConnectionAndResources(connection, statement);
        }
    }

    @Override
    public void updateDonationFlag(int itemId,boolean forDonation) {
     
        Connection connection = null;
        PreparedStatement statement = null;
        String sqlQuery = "UPDATE Item SET forDonation = ? WHERE item_id = ?";
        
        try {
            connection = DataSource.getConnection();
            statement = connection.prepareStatement(sqlQuery);

            statement.setBoolean(1, forDonation);
            statement.setInt(2, itemId);

            // Execute the update
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeConnectionAndResources(connection, statement);
        }
    }

}
