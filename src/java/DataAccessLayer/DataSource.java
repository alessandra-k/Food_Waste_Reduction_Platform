package DataAccessLayer;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;

/**
 *
 * @author aless
 */
public class DataSource {

    private static Connection connection = null;

    /**
     * Private constructor to prevent instantiation of this class.
     */
    private DataSource() {
    }

    /**
     * Establish a database connection. Only one connection is used for the
     * entire application to prevent memory leaks.
     *
     * @return The database connection
     */
    public static Connection getConnection() {
        try {
            if (connection == null || connection.isClosed()) {
                String connectionString = "jdbc:mysql://localhost:3306/FWRP";
                String username = "root";
                String password = "Lucas183729@";
                connection = DriverManager.getConnection(connectionString, username, password);
            } else {
                System.out.println("Cannot create new connection, using existing one");
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return connection;
    }
    
   
    
    
    /**
     * Closes the database connection and prepared statement resources.
     *
     * @param connection The database connection to close.
     * @param statement The prepared statement to close.
     */
     public static void closeConnectionAndResources(Connection connection, PreparedStatement statement) {
        try {
            if (statement != null) {
                statement.close();
            }
            if (connection != null) {
                connection.close();
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    /**
     * Closes the database connection and prepared statement resources.
     *
     * @param connection The database connection to close.
     * @param statement The prepared statement to close.
     * @param resultSet
     */
    public static void closeConnectionAndResources(Connection connection, PreparedStatement statement, ResultSet resultSet) {
        try {
            if (resultSet != null) {
                resultSet.close();
            }
            if (statement != null) {
                statement.close();
            }
            if (connection != null) {
                connection.close();
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
    
    

}
