package DataAccessLayer;

import static DataAccessLayer.DataSource.closeConnectionAndResources;
import Model.Address;
import Model.User;

import java.sql.Statement;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;

/**
 *
 * @author aless
 */
public class AddressDAOImpl implements AddressDAO {

    @Override
    public void addAddress(Address address) {
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet generatedKeys = null;
        String sqlQuery = "INSERT INTO Address (street, postalCode) VALUES (?, ?)";

        try {
            
            connection = DataSource.getConnection();
             statement = connection.prepareStatement(sqlQuery, Statement.RETURN_GENERATED_KEYS);
        // Set the parameters
        statement.setString(1, address.getStreet());
        statement.setString(2, address.getPostalCode());

        int rowsAffected = statement.executeUpdate();

        if (rowsAffected == 1) {
            generatedKeys = statement.getGeneratedKeys();
            if (generatedKeys.next()) {
                int generatedId = generatedKeys.getInt(1);
                address.setAddress_id(generatedId); // Set the generated ID to the address object
            }
        }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeConnectionAndResources(connection, statement, generatedKeys);
        }
}

    @Override
    public void updateAddress(int addressId, User user) {
    Connection connection = null;
        PreparedStatement statement = null;
        String sqlQuery = "UPDATE Address SET user_id = ? WHERE address_id = ?";

        try {
             connection = DataSource.getConnection();
            statement = connection.prepareStatement(sqlQuery);

            statement.setInt(1, user.getUser_id());
            statement.setInt(2, addressId);
            statement.executeUpdate();

        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {

            closeConnectionAndResources(connection, statement);

        }
    }

}
