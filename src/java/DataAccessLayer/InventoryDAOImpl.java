package DataAccessLayer;

import static DataAccessLayer.DataSource.closeConnectionAndResources;
import Model.Inventory;
import Model.Item;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 *
 * @author aless
 */
public class InventoryDAOImpl implements InventoryDAO {

    @Override
    public void addToInventory(String inventoryType, int subclassId, int itemId, int quantity) {
        Connection connection = null;
        PreparedStatement statement = null;

        String sqlQuery = "INSERT INTO Inventory (inventory_id,inventory_type, subclass_id, item_id, quantity) VALUES (?,?, ?, ?, ?)";

        try {
            connection = DataSource.getConnection();
            statement = connection.prepareStatement(sqlQuery);

            statement.setInt(1, 1);
            statement.setString(2, inventoryType);
            statement.setInt(3, subclassId);
            statement.setInt(4, itemId);
            statement.setInt(5, quantity);

            statement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeConnectionAndResources(connection, statement);
        }
    }

    @Override
    public Inventory getInventoryById(int inventoryId) {
        return null;
    }

    @Override
    public List<Inventory> getAllInventories() {
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        List<Inventory> inventories = new ArrayList<>();
        String sqlQuery = "SELECT * FROM Inventory";
        try {
            connection = DataSource.getConnection();
            statement = connection.prepareStatement(sqlQuery);
            resultSet = statement.executeQuery();
            while (resultSet.next()) {
                Inventory inventory = new Inventory();
                inventory.setInventory_id(resultSet.getInt("inventory_id"));
                // Add more fields as needed
                inventories.add(inventory);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeConnectionAndResources(connection, statement, resultSet);
        }
        return inventories;
    }

    @Override
    public void updateInventory(int itemId, int quantity) {
        Connection connection = null;
        PreparedStatement statement = null;

        String sqlQuery = "UPDATE Inventory SET quantity = ? WHERE item_id = ?";
        try {
            connection = DataSource.getConnection();
            statement = connection.prepareStatement(sqlQuery);
            statement.setInt(1, quantity);
            statement.setInt(2, itemId);
            statement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeConnectionAndResources(connection, statement);
        }
    }

    @Override
    public void deleteItem_FromIventory(int itemID) {
        Connection connection = null;
        PreparedStatement statement = null;
        String sqlQuery = "DELETE FROM Inventory WHERE item_id = ?";
        try {
            connection = DataSource.getConnection();
            statement = connection.prepareStatement(sqlQuery);
            statement.setInt(1, itemID);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeConnectionAndResources(connection, statement);
        }
    }

    @Override
    public void deleteInventory(int inventoryId) {

    }

    @Override
    public boolean itemExists(int itemId) {
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        boolean exists = false;
        String sqlQuery = "SELECT * FROM Inventory WHERE item_id = ?";

        try {
            connection = DataSource.getConnection();
            statement = connection.prepareStatement(sqlQuery);
            statement.setInt(1, itemId);
            resultSet = statement.executeQuery();

            // If there is at least one record, the item exists
            if (resultSet.next()) {
                exists = true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeConnectionAndResources(connection, statement, resultSet);
        }

        return exists;
    }
}
