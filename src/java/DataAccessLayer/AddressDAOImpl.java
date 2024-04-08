package DataAccessLayer;

import static DataAccessLayer.DataSource.closeConnectionAndResources;
import Model.Address;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;
import java.sql.ResultSet;
import java.util.logging.Level;
import java.util.logging.Logger;

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
        String sqlQuery = "INSERT INTO Address (street, postalCode, user_id) VALUES (?, ?, ?)";

        try {
            connection = DataSource.getConnection();
            statement = connection.prepareStatement(sqlQuery);

            // Set the parameters
            statement.setString(1, address.getStreet());
            statement.setString(2, address.getPostalCode());
            statement.setInt(3, address.getUser().getUser_id()); // Assuming you have a method to get the user ID

            int rowsAffected = statement.executeUpdate();

            if (rowsAffected == 1) {
                generatedKeys = statement.getGeneratedKeys();
                if (generatedKeys.next()) {
                    int generatedId = generatedKeys.getInt(1);
                    address.setAddress_id(generatedId); // Set the generated ID to the address object
                }
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            if (generatedKeys != null) {
                try {
                    generatedKeys.close();
                } catch (SQLException ex) {
                    Logger.getLogger(AddressDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            closeConnectionAndResources(connection, statement);

        }
    }

    @Override
    public Address getAddressById(int addressId) {
        return null;
    }

    @Override
    public List<Address> getAllAddresses() {
        return null;
    }

    @Override
    public void updateAddress(int addressId) {

    }

    @Override
    public void deleteAddress(int addressId) {

    }

}
