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
public class SurplusFoodSubject implements Subject {
  private List<Observer> observers = new ArrayList<>();

    @Override
    public void registerObserver(Observer observer) {
        observers.add(observer);
    }

    @Override
    public void removeObserver(Observer observer) {
        observers.remove(observer);
    }

    @Override
    public void notifyObservers(String itemName, double itemPrice) {
        for (Observer observer : observers) {
            observer.update(itemName, itemPrice);
        }
    }

    // Method to trigger notification
    public void addSurplusFoodItem(String itemName, double itemPrice) {
        notifyObservers(itemName, itemPrice);
    }
}
