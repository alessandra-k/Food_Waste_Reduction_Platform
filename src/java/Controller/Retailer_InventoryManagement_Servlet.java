package Controller;

import BusinessLayer.ItemBusinessLogic;
import Model.Item;
import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author aless
 */
public class Retailer_InventoryManagement_Servlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.getRequestDispatcher("/Views/retailer_InventoryManagement.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        // Extract form data
        String name = request.getParameter("name");
        String description = request.getParameter("description");
        double price = Double.parseDouble(request.getParameter("price"));
        String expirationDateForm = request.getParameter("expiration");
        boolean forDonation = request.getParameter("donation") != null;
        int discountId = Integer.parseInt(request.getParameter("discount"));

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
        newItem.setForDonation(forDonation);
        newItem.setDiscount_id(discountId);

        // Use ItemBusinessLogic to add the item
        ItemBusinessLogic itemBusinessLogic = new ItemBusinessLogic();
        itemBusinessLogic.addItem(newItem);

        request.getRequestDispatcher("/Views/retailer_InventoryManagement.jsp").forward(request, response);
    }

    @Override
    public String getServletInfo() {
        return "Retailer Servlet";
    }// </editor-fold>

}
