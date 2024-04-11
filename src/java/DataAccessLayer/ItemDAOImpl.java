package DataAccessLayer;

import static DataAccessLayer.DataSource.closeConnectionAndResources;
import Model.Item;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author aless
 */
public class ItemDAOImpl implements ItemDAO {

    @Override
    public void addItem(Item item) {
        Connection connection = null;
        PreparedStatement statement = null;
        String sqlQuery = "INSERT INTO Item (name, description, price, expirationDate, discount_id) VALUES (?, ?, ?, ?,?)";
        ResultSet generatedKeys = null;

        try {
            connection = DataSource.getConnection();
            statement = connection.prepareStatement(sqlQuery);

            statement.setString(1, item.getName());
            statement.setString(2, item.getDescription());
            statement.setDouble(3, item.getPrice());
            statement.setDate(4, new java.sql.Date(item.getExpirationDate().getTime()));
            statement.setInt(5,1);

            int rowsAffected = statement.executeUpdate();

            if (rowsAffected == 1) {
                generatedKeys = statement.getGeneratedKeys();
                if (generatedKeys.next()) {
                    int generatedId = generatedKeys.getInt(1);
                    item.setItem_id(generatedId); // Set the generated ID to the user object
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeConnectionAndResources(connection, statement, generatedKeys);
        }
    }

    @Override
    public Item getItemById(int itemId) {
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        String sqlQuery = "SELECT * FROM Item WHERE item_id = ?";
        Item item = null;

        try {
            connection = DataSource.getConnection();
            statement = connection.prepareStatement(sqlQuery);

            statement.setInt(1, itemId);
            resultSet = statement.executeQuery();
            if (resultSet.next()) {
                item = new Item();
                item.setItem_id(resultSet.getInt("item_id"));
                item.setName(resultSet.getString("name"));
                item.setDescription(resultSet.getString("description"));
                item.setPrice(resultSet.getDouble("price"));
                item.setExpirationDate(resultSet.getDate("expirationDate"));
                item.setForDonation(resultSet.getBoolean("forDonation"));
                item.setDiscount_id(resultSet.getInt("discount_id"));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeConnectionAndResources(connection, statement, resultSet);
        }

        return item;
    }

    @Override
    public List<Item> getAllItems() {
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        String sqlQuery = "SELECT * FROM Item";
        List<Item> itemsList = new ArrayList<>();

        try {
            connection = DataSource.getConnection();
            statement = connection.prepareStatement(sqlQuery);

            resultSet = statement.executeQuery();
            while (resultSet.next()) {
                Item item = new Item();
                item.setItem_id(resultSet.getInt("item_id"));
                item.setName(resultSet.getString("name"));
                item.setDescription(resultSet.getString("description"));
                item.setPrice(resultSet.getDouble("price"));
                item.setExpirationDate(resultSet.getDate("expirationDate"));
                item.setForDonation(resultSet.getBoolean("forDonation"));
                item.setDiscount_id(resultSet.getInt("discount_id"));
                itemsList.add(item);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeConnectionAndResources(connection, statement, resultSet);
        }

        return itemsList;
    }

    @Override
    public void updateItem(int itemId, boolean forDonation, int discountId) {
        Connection connection = null;
        PreparedStatement statement = null;
        String sqlQuery = "UPDATE Item SET forDonation = ?, discount_id = ? WHERE item_id = ?";
        try {
            connection = DataSource.getConnection();
            statement = connection.prepareStatement(sqlQuery);

            statement.setBoolean(1, forDonation);
            statement.setInt(2, discountId);
            statement.setInt(3, itemId);

            // Execute the update
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeConnectionAndResources(connection, statement);
        }
    }

    @Override
    public void deleteItem(int itemId) {
        Connection connection = null;
        PreparedStatement statement = null;
        String sqlQuery = "DELETE FROM Item WHERE item_id = ?";

        try {
            connection = DataSource.getConnection();
            statement = connection.prepareStatement(sqlQuery);
            statement.setInt(1, itemId);
            statement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeConnectionAndResources(connection, statement);
        }
    }

}
