package DataAccessLayer;

import static DataAccessLayer.DataSource.closeConnectionAndResources;
import Model.DonationItems;
import Model.ExcessDemandItems;
import Model.General_Items_Inventory;
import Model.Inventory;
import Model.Item;
import Model.SalesItems;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @author aless
 */
public class InventoryDAOImpl implements InventoryDAO {

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

    @Override
    public void addToInventory(int itemId, int quantity) {
        Connection connection = null;
        PreparedStatement statement = null;
        String sqlQuery = "INSERT INTO Inventory (item_id, quantity) VALUES (?,?)";

        try {
            connection = DataSource.getConnection();
            statement = connection.prepareStatement(sqlQuery);

            statement.setInt(1, itemId);
            statement.setInt(2, quantity);

            statement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeConnectionAndResources(connection, statement);
        }
    }

    @Override
    public void updateInventory(int itemId, int quantity) {

        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;

        String selectQuery = "SELECT quantity FROM Inventory WHERE item_id = ?";
        // Retrieve the current quantity
        int currentQuantity = 0;
        try {
            connection = DataSource.getConnection();
            statement = connection.prepareStatement(selectQuery);
            statement.setInt(1, itemId);
            resultSet = statement.executeQuery();
            if (resultSet.next()) {
                currentQuantity = resultSet.getInt("quantity");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeConnectionAndResources(null, statement, resultSet);
        }

        // Add the new quantity to the current quantity
        int updatedQuantity = currentQuantity + quantity;

        // Update the inventory with the total quantity
        String sqlQuery = "UPDATE Inventory SET quantity = ? WHERE item_id = ?";
        try {
            statement = connection.prepareStatement(sqlQuery);
            statement.setInt(1, updatedQuantity);
            statement.setInt(2, itemId);
            statement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeConnectionAndResources(connection, statement, resultSet);
        }
    }

    @Override
    public void updateInventory_ReduceQuantity(int itemId, int quantity) {
        Connection connection = null;
        PreparedStatement statement = null;

        String updateQuery = "UPDATE Inventory SET quantity = quantity - ? WHERE item_id = ? AND quantity >= ?";

        try {
            connection = DataSource.getConnection();
            statement = connection.prepareStatement(updateQuery);
            statement.setInt(1, quantity);
            statement.setInt(2, itemId);
            statement.setInt(3, quantity);

            int rowsUpdated = statement.executeUpdate();

            if (rowsUpdated == 0) {
                System.out.println("Insufficient quantity in inventory for item ID: " + itemId);
            } else {
                // Commit the transaction if the update was successful
                connection.commit();
            }
        } catch (SQLException e) {
            try {
                // Rollback the transaction in case of any exception
                if (connection != null) {
                    connection.rollback();
                }
                e.printStackTrace();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        } finally {
            // Close connection and resources
            closeConnectionAndResources(connection, statement);
        }
    }

    @Override
    public List<SalesItems> getItemsWithDiscount() {

        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        List<SalesItems> salesItemList = new ArrayList<>();

        // SQL query to join Item, Inventory, and Discount tables
        String sqlQuery = "SELECT i.item_id, i.name, i.description, i.price, i.expirationDate, inv.quantity, d.discount_description "
                + "FROM Item i "
                + "JOIN Inventory inv ON i.item_id = inv.item_id "
                + "JOIN Discount d ON i.discount_id = d.discount_id "
                + "WHERE i.discount_id > 1 AND i.forDonation = 0";

        try {
            connection = DataSource.getConnection();
            statement = connection.prepareStatement(sqlQuery);
            resultSet = statement.executeQuery();

            while (resultSet.next()) {
                // Retrieve item details from the result set
                int itemId = resultSet.getInt("item_id");
                String name = resultSet.getString("name");
                String description = resultSet.getString("description");
                double price = resultSet.getDouble("price");
                Date expirationDate = resultSet.getDate("expirationDate");
                int quantity = resultSet.getInt("quantity");
                String discountDescription = resultSet.getString("discount_description");

                // Create a SalesItem object and add it to the list
                SalesItems salesItem = new SalesItems(itemId, name, description, price, expirationDate, quantity, discountDescription);
                salesItemList.add(salesItem);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            closeConnectionAndResources(connection, statement, resultSet);
        }
        return salesItemList;
    }

    @Override
    public List<DonationItems> getDonationItems() {

        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        List<DonationItems> donationItemsList = new ArrayList<>();

        // SQL query to join Item and Inventory
        String sqlQuery = "SELECT i.item_id, i.name, i.description, i.price, i.expirationDate, i.forDonation, inv.quantity "
                + "FROM Item i "
                + "JOIN Inventory inv ON i.item_id = inv.item_id "
                + "JOIN Discount d ON i.discount_id = d.discount_id "
                + "WHERE i.forDonation = 1";

        try {
            connection = DataSource.getConnection();
            statement = connection.prepareStatement(sqlQuery);
            resultSet = statement.executeQuery();

            while (resultSet.next()) {
                // Retrieve item details from the result set
                int itemId = resultSet.getInt("item_id");
                String name = resultSet.getString("name");
                String description = resultSet.getString("description");
                double price = resultSet.getDouble("price");
                Date expirationDate = resultSet.getDate("expirationDate");
                int quantity = resultSet.getInt("quantity");

                // Create a SalesItem object and add it to the list
                DonationItems donationItem = new DonationItems(itemId, name, description, price, expirationDate, quantity);
                donationItemsList.add(donationItem);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            closeConnectionAndResources(connection, statement, resultSet);
        }
        return donationItemsList;
    }

    @Override
    public List<ExcessDemandItems> getItemsWithExcessDemand() {

        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        List<ExcessDemandItems> itemsWithExcessDemand = new ArrayList<>();

        String sqlQuery = "SELECT i.item_id, i.name, i.description, i.price, i.expirationDate, inv.quantity "
                + "FROM Item i "
                + "JOIN Inventory inv ON i.item_id = inv.item_id "
                + "WHERE inv.quantity >= 200";

        try {
            connection = DataSource.getConnection();
            statement = connection.prepareStatement(sqlQuery);
            resultSet = statement.executeQuery();

            while (resultSet.next()) {
                // Retrieve item details from the result set
                int itemId = resultSet.getInt("item_id");
                String name = resultSet.getString("name");
                String description = resultSet.getString("description");
                double price = resultSet.getDouble("price");
                Date expirationDate = resultSet.getDate("expirationDate");
                int quantity = resultSet.getInt("quantity");

                // Create an Item object and add it to the list
                ExcessDemandItems item = new ExcessDemandItems(itemId, name, description, price, expirationDate, quantity);
                itemsWithExcessDemand.add(item);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            closeConnectionAndResources(connection, statement, resultSet);
        }

        return itemsWithExcessDemand;
    }

    @Override
    public List<Item> getItemsCloseToExpiration() {
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        List<Item> itemsCloseToExpiration = new ArrayList<>();

        String sqlQuery = "SELECT * FROM Item WHERE expirationDate BETWEEN ? AND ?";

        try {
            connection = DataSource.getConnection();
            statement = connection.prepareStatement(sqlQuery);

            // Get the current date
            LocalDate currentDate = LocalDate.now();
            int daysToExpire = 7;

            // Calculate the expiration date
            LocalDate exipiredDateLimit = currentDate.plusDays(daysToExpire);

            // Set parameters for the SQL query
            statement.setDate(1, java.sql.Date.valueOf(currentDate));
            statement.setDate(2, java.sql.Date.valueOf(exipiredDateLimit));

            resultSet = statement.executeQuery();

            while (resultSet.next()) {

                int itemId = resultSet.getInt("item_id");
                String name = resultSet.getString("name");
                String description = resultSet.getString("description");
                double price = resultSet.getDouble("price");
                // Convert expirationDate to java.sql.Date
                LocalDate expirationDateLocalDate = resultSet.getDate("expirationDate").toLocalDate();
                java.sql.Date expirationDate = java.sql.Date.valueOf(expirationDateLocalDate);
                int discountId = resultSet.getInt("discount_id");

                // Create an Item object and add it to the list
                Item item = new Item(itemId, name, description, price, expirationDate);
                item.setDiscount_id(discountId);

                itemsCloseToExpiration.add(item);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            closeConnectionAndResources(connection, statement, resultSet);
        }

        return itemsCloseToExpiration;
    }

    @Override
    public List<General_Items_Inventory> getItemsAvailableForPurchase() {

        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        List<General_Items_Inventory> availableItems = new ArrayList<>();

        // SQL query to join Item, Inventory, and Discount tables
        String sqlQuery = "SELECT i.item_id, i.name, i.description, i.price, i.expirationDate, inv.quantity, d.discount_description "
                + "FROM Item i "
                + "JOIN Inventory inv ON i.item_id = inv.item_id "
                + "JOIN Discount d ON i.discount_id = d.discount_id "
                + "WHERE i.forDonation = false";

        try {
            connection = DataSource.getConnection();
            statement = connection.prepareStatement(sqlQuery);
            resultSet = statement.executeQuery();

            while (resultSet.next()) {
                // Retrieve item details from the result set
                int itemId = resultSet.getInt("item_id");
                String name = resultSet.getString("name");
                String description = resultSet.getString("description");
                double price = resultSet.getDouble("price");
                Date expirationDate = resultSet.getDate("expirationDate");
                int quantity = resultSet.getInt("quantity");
                String discountDescription = resultSet.getString("discount_description");

                // Create an Item object and add it to the list
                General_Items_Inventory item = new General_Items_Inventory(itemId, name, description, price, expirationDate, quantity, discountDescription);
                availableItems.add(item);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeConnectionAndResources(connection, statement, resultSet);
        }

        return availableItems;
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
    public General_Items_Inventory getItemById(int itemId) {
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        General_Items_Inventory item = null;

        String query = "SELECT i.item_id, i.name, i.description, i.price, i.expirationDate, inv.quantity, d.discount_description "
                + "FROM Item i "
                + "JOIN Inventory inv ON i.item_id = inv.item_id "
                + "JOIN Discount d ON i.discount_id = d.discount_id "
                + "WHERE i.item_id = ?";

        try {
            connection = DataSource.getConnection();
            statement = connection.prepareStatement(query);
            statement.setInt(1, itemId);
            resultSet = statement.executeQuery();

            if (resultSet.next()) {
                int retrievedItemId = resultSet.getInt("item_id");
                String name = resultSet.getString("name");
                String description = resultSet.getString("description");
                double price = resultSet.getDouble("price");
                java.util.Date expirationDate = resultSet.getDate("expirationDate");
                int quantity = resultSet.getInt("quantity");
                String discountDescription = resultSet.getString("discount_description");

                item = new General_Items_Inventory(retrievedItemId, name, description, price, expirationDate, quantity, discountDescription);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeConnectionAndResources(connection, statement, resultSet);
        }

        return item;
    }
}
