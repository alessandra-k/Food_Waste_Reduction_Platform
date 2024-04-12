package DataAccessLayer;

import static DataAccessLayer.DataSource.closeConnectionAndResources;
import java.sql.ResultSet;

import Model.User;
import Model.UserBuilder;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

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
            statement = connection.prepareStatement(sqlQuery, Statement.RETURN_GENERATED_KEYS);

            statement.setString(1, user.getUserName());
            statement.setString(2, user.getUserEmail());
            statement.setString(3, user.getUserPassword());
            statement.setInt(4, user.getUserType_id());
            statement.setInt(5, user.getAddress_id());
            statement.setString(6, user.getPhone());

            int rowsAffected = statement.executeUpdate();

            if (rowsAffected == 1) {
                generatedKeys = statement.getGeneratedKeys();
                if (generatedKeys.next()) {
                    int generatedId = generatedKeys.getInt(1);
                    user.setUser_id(generatedId); // Set the generated ID to the user object
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeConnectionAndResources(connection, statement, generatedKeys);
        }
    }

    @Override
    public User authenticateUser(String email, String password) {
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        User user = null;
        String sqlQuery = "SELECT * FROM User WHERE userEmail = ? AND userPassword = ?";

        try {

            connection = DataSource.getConnection();
            statement = connection.prepareStatement(sqlQuery);

            statement.setString(1, email);
            statement.setString(2, password);
            // Execute query
            resultSet = statement.executeQuery();

            if (resultSet.next()) {
                // Use the UserBuilder to construct the User object
                user = UserBuilder.create()
                        .userName(resultSet.getString("userName"))
                        .userEmail(resultSet.getString("userEmail"))
                        .userPassword(resultSet.getString("userPassword"))
                        .userType_id(resultSet.getInt("userType_id"))
                        .addressId(resultSet.getInt("address_id"))
                        .phone(resultSet.getString("phone"))
                        .build();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeConnectionAndResources(connection, statement, resultSet);
        }
        return user;
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
