package DataAccessLayer;

import Model.User;
import java.util.List;

/**
 *
 * @author aless
 */
public interface UserDAO {

    void addUser(User user);

    User getUserById(int userId);

    List<User> getAllUsers();

    void updateUser(int userId);

    void deleteUser(int userId);
}
