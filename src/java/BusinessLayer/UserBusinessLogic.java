
package BusinessLayer;

import DataAccessLayer.UserDAO;
import DataAccessLayer.UserDAOImpl;
import Model.User;

/**
 *
 * @author aless
 */
public class UserBusinessLogic {
    
     private UserDAO userDAO = null;

    public UserBusinessLogic() {
        userDAO = new UserDAOImpl();
    }
    
    public void addUser(User user) {
        userDAO.addUser(user);
    }
    
    public User authenticateUser(String email, String password){
        return userDAO.authenticateUser(email, password);
           }
    
}
