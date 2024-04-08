
package DataAccessLayer;
import static DataAccessLayer.DataSource.closeConnectionAndResources;
import java.sql.ResultSet;

import Model.User;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author aless
 */
public class UserDAOImpl implements UserDAO {

    @Override
    public void addUser(User user) {
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet generatedKeys = null;
        String sqlQuery = "INSERT INTO User (userName, userEmail, userPassword, userType_id, address_id, phone) VALUES (?, ?, ?, ?, ?, ?)";

        try {
            connection = DataSource.getConnection();
            statement = connection.prepareStatement(sqlQuery);
            
        statement.setString(1, user.getUserName());
        statement.setString(2, user.getUserEmail());
        statement.setString(3, user.getUserPassword());
        statement.setInt(4, user.getUserType_id());
        statement.setInt(5, user.getAddress().getAddress_id());
        statement.setString(6, user.getPhone());


            int rowsAffected = statement.executeUpdate();
            
            
       if (rowsAffected == 1) {
            generatedKeys = statement.getGeneratedKeys();
            if (generatedKeys.next()) {
                int generatedId = generatedKeys.getInt(1);
                user.setUser_id(generatedId); // Set the generated ID to the user object
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
    public User getUserById(int userId) {
        
        return null;
        
    }

    @Override
    public List<User> getAllUsers() {
        
        return null;
        
    }

    @Override
    public void updateUser(int userId) {
       
    }

    @Override
    public void deleteUser(int userId) {
        
    }
    
}
