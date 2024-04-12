/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Controller;

import DataAccessLayer.SubscriptionDAO;
import DataAccessLayer.SubscriptionDAOImpl;
import Model.CommunicationMethod;
import Model.FoodPreference;
import Model.Neighbourhood;
import Model.Subscription;
import ObserverPattern.SurplusFoodSubject;
import ObserverPattern.UserNotificationObserver;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *Peace added this 
 * @author morio
 */
@WebServlet(name = "MySubscription_Servlet", urlPatterns = {"/MySubscription_Servlet"})
public class MySubscription_Servlet extends HttpServlet {
    private SurplusFoodSubject subject = new SurplusFoodSubject();
    private SubscriptionDAO subscriptionDAO;

    @Override
    public void init() {
        subscriptionDAO = new SubscriptionDAOImpl();
    }


  @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
         // Retrieve selected food preferences from session
        HttpSession session = request.getSession();
        int user_id = 1;
        List<String> selectedFoodPreferences = (List<String>) session.getAttribute("selectedFoodPreferences");
        // Create a new user observer
        UserNotificationObserver userObserver = new UserNotificationObserver(user_id);

        // Register user as an observer
        subject.registerObserver(userObserver);
        // Fetch subscription details from the database based on the user's subscription
        Subscription subscription = subscriptionDAO.getSubscriptionByUserId(user_id); 
        // Get the names of the enum constants
        String neighbourhood = Neighbourhood.values()[subscription.getNeighbourhood_id() - 1].name().replaceAll("_", " ");
        String communicationMethod = CommunicationMethod.values()[subscription.getCommunicationMethod_id() - 1].name();
        List<String> foodPreferences = new ArrayList<>();
    if (subscription.getFoodPreferences_id() != 0) {
        String[] prefIds = String.valueOf(subscription.getFoodPreferences_id()).split(",");
        for (String prefId : prefIds) {
            FoodPreference preference = FoodPreference.values()[Integer.parseInt(prefId) - 1];
            foodPreferences.add(preference.name().replaceAll("_", " "));
        }
    }

        // Set subscription details as request attributes
        request.setAttribute("neighbourhood", neighbourhood);
        request.setAttribute("communicationMethod", communicationMethod);
        request.setAttribute("foodPreferences", foodPreferences);
    
        // Forward the request to the JSP page for displaying surplus food
        request.getRequestDispatcher("/Views/mySubscriptionPage.jsp").forward(request, response);
    }  
    

    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {
    // Get the user ID from session or wherever it's stored
    int user_id = 1; // Move the declaration before it's used

   
    if (request.getParameter("unsubscribe") != null) {
        

        // Delete the subscription data from the database
        subscriptionDAO.deleteSubscriptionByUserId(user_id);

        // Set a message attribute in request
        request.setAttribute("message", "You have unsubscribed successfully.");

        // Forward to the same page
        request.getRequestDispatcher("/Views/mySubscriptionPage.jsp").forward(request, response);
    }
}

 
    
}
