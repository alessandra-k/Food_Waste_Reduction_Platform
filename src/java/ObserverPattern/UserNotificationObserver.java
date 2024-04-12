/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ObserverPattern;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author morio
 */
public class UserNotificationObserver implements Observer{
    private int user_id;
    private List<String> notifications;

    public UserNotificationObserver(int userId) {
        this.user_id = user_id;
        this.notifications = new ArrayList<>();
    }

    @Override
    public void update(String itemName, double itemPrice) {
        String notification = "New Surplus Food Item \"" + itemName + "\" available for $" + itemPrice;
        notifications.add(notification);
        System.out.println("Notification sent to User " + user_id + ": " + notification);
    }

    public List<String> getNotifications() {
        return notifications;
    }
}
