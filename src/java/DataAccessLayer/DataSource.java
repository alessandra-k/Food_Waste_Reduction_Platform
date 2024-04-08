
package DataAccessLayer;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Properties;

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
   * Establish a database connection.
   * Only one connection is used for the entire application to prevent memory leaks.
   * @return The database connection
   */
     public static Connection getConnection() {

        String[] connectionInfo = openPropsFile();

        try {
            if (connection == null || connection.isClosed()) {

                connection = DriverManager.getConnection(connectionInfo[0], connectionInfo[1], connectionInfo[2]);

            } else {
                System.out.println("Cannot create new connection, using existing one");
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return connection;
    }

    /**
     * Opens the database properties file and retrieves connection information.
     * @return An array containing database connection information
     */
    private static String[] openPropsFile() {
        // added use of Properties and try-with-resources - kriger
        Properties props = new Properties();

        //../src/database.properties"
        try (InputStream in = Files.newInputStream(Paths.get("C:\\Users\\aless\\Documents\\NetBeansProjects\\Food_Waste_Reduction_Plataform\\src\\data\\database.properties"))){
            props.load(in);
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }// catch()

        String connectionString = props.getProperty("jdbc.url");
        String username = props.getProperty("jdbc.username");
        String password = props.getProperty("jdbc.password");

        String[] info = new String[3];
        info[0] = connectionString;
        info[1] = username;
        info[2] = password;

        return info;
    }

    /**
     * Closes the database connection and prepared statement resources.
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
}
