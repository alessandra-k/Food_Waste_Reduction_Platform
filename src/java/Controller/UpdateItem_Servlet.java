package Controller;

import DataAccessLayer.InventoryDAOImpl;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author allan
 */
public class UpdateItem_Servlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int itemId = Integer.parseInt(request.getParameter("itemId"));
        int quantity = Integer.parseInt(request.getParameter("itemQTD"));

        // Check if the item exists in the inventory
        InventoryDAOImpl inventoryDAO = new InventoryDAOImpl();
        boolean itemExists = inventoryDAO.itemExists(itemId);

        // If the item exists, update the quantity; otherwise, add a new record
        if (!itemExists) {
          inventoryDAO.addToInventory("General Items", 1, itemId, quantity);
        } else {
        
         inventoryDAO.updateInventory(itemId, quantity);
        }
          request.getRequestDispatcher("/Views/retailer_InventoryManagement.jsp").forward(request, response);
    }

    @Override
    public String getServletInfo() {
        return "UpdateItem Servlet";
    }// </editor-fold>

}
