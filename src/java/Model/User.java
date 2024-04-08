package Model;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author aless
 */
public class User {

    private int user_id;
    private String userName;
    private String userEmail;
    private String userPassword;
    private int userType_id;
    private Address address; // Each user has an address
    private String phone;
    private List<Subscription> subscriptions;

    public User(UserBuilder builder) {
//        user_id = builder.getUser_id();
        userName = builder.getUserName();
        userEmail = builder.getUserEmail();
        userPassword = builder.getUserPassword();
        userType_id = builder.getUserType_id();
        address = builder.getAddress();
        phone = builder.getPhone();
        subscriptions = builder.getSubscriptions();
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    public int getUserType_id() {
        return userType_id;
    }

    public void setUserType_id(int userType_id) {
        this.userType_id = userType_id;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
    
        public List<Subscription> getSubscriptions() {
        return subscriptions;
    }

    public void addSubscription(Subscription subscription) {
        if (subscriptions == null) {
            subscriptions = new ArrayList<>();
        }
        subscriptions.add(subscription);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(userName).append(" ")
                .append(userEmail).append(" ")
                .append(userPassword).append(" ")
                .append(userType_id).append(" ")
                .append(address).append(" ")
                .append(phone);
        return sb.toString();

    }

}
