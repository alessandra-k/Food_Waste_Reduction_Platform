
package Model;

/**
 *
 * @author aless
 */
public enum UserType {
    
    RETAILER(1),
    CONSUMER(2),
    CHARITY(3);
    
    private final int userType_id;
    
    private UserType(int id) {
        this.userType_id = id;
    }
    
    public int getId() {
        return userType_id;
    }
}