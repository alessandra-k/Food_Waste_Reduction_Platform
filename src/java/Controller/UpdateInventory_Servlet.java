package Controller;

import BusinessLayer.InventoryBusinessLogic;
import DataAccessLayer.InventoryDAOImpl;
import java.io.IOException;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author allan
 */
public class UpdateInventory_Servlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        Enumeration<String> parameterNames = request.getParameterNames();
        while (parameterNames.hasMoreElements()) {
            String paramName = parameterNames.nextElement();
            if (paramName.startsWith("itemQTD_")) {
                // Extract item ID from parameter name
                int itemId = Integer.parseInt(paramName.substring("itemQTD_".length()));
                // Get quantity for the current item ID
                String quantityParam = request.getParameter(paramName);
                if (quantityParam != null && !quantityParam.isEmpty()) {
                    int quantity = Integer.parseInt(quantityParam);
                    // Check if the item exists in the inventory
                    InventoryBusinessLogic inventory = new InventoryBusinessLogic();
                    boolean itemExists = inventory.itemExists(itemId);
                    // If the item exists, update its quantity; otherwise, add it to the inventory
                    if (itemExists) {
                        inventory.updateInventory(itemId, quantity);
                    } else {
                        inventory.addToInventory(itemId, quantity);
                    }
                }
            }
        }
        request.getRequestDispatcher("/Views/retailer_InventoryManagement.jsp").forward(request, response);
    }

    @Override
    public String getServletInfo() {
        return "UpdateItem Servlet";
    }// </editor-fold>

}
