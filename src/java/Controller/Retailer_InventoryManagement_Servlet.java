package Controller;

import BusinessLayer.ItemBusinessLogic;
import Model.Item;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author aless
 */
public class Retailer_InventoryManagement_Servlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Check if session is valid
        HttpSession session = request.getSession(false);
        if (session != null && session.getAttribute("user") != null) {
            String action = request.getParameter("action");
            switch (action) {
                case "surplus" ->
                    request.getRequestDispatcher("/Views/SurplusItems_Management.jsp").forward(request, response);
                case "RetailerHome" ->
                    request.getRequestDispatcher("/Views/retailerPage.jsp").forward(request, response);
                case "Inventory" ->
                    request.getRequestDispatcher("/Views/retailer_InventoryManagement.jsp").forward(request, response);
                default -> {
                }
            }
        } else {

            request.getRequestDispatcher("/Views/login.jsp").forward(request, response);

        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String button = request.getParameter("button");

        if ("addItem".equals(button)) {
            // Extract form data for adding a new item
            String name = request.getParameter("name");
            String description = request.getParameter("description");
            double price = Double.parseDouble(request.getParameter("price"));
            String expirationDateForm = request.getParameter("expiration");

            // Parse expiration date string into java.util.Date object
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            Date expirationDate = null;
            try {
                expirationDate = dateFormat.parse(expirationDateForm);
            } catch (ParseException e) {
                e.printStackTrace(); // Handle parsing exception
            }

            // Create Item object
            Item newItem = new Item();
            newItem.setName(name);
            newItem.setDescription(description);
            newItem.setPrice(price);
            newItem.setExpirationDate(expirationDate);

            // Use ItemBusinessLogic to add the item
            ItemBusinessLogic itemBusinessLogic = new ItemBusinessLogic();
            itemBusinessLogic.addItem(newItem);
        } else if ("updateItem".equals(button)) {
            // Extract form data for updating item
            int itemId = Integer.parseInt(request.getParameter("itemID"));
            boolean forDonation = request.getParameter("donation") != null;
            int discountId = Integer.parseInt(request.getParameter("discount"));

            // Use ItemBusinessLogic to update the item
            ItemBusinessLogic itemBusinessLogic = new ItemBusinessLogic();
            itemBusinessLogic.updateItem(itemId, forDonation, discountId);
        }

        request.getRequestDispatcher("/Views/retailer_InventoryManagement.jsp").forward(request, response);
    }

    @Override
    public String getServletInfo() {
        return "Retailer Servlet";
    }// </editor-fold>

}
