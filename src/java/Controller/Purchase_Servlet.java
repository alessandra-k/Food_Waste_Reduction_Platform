package Controller;

import BusinessLayer.InventoryBusinessLogic;
import java.io.IOException;
import java.util.Enumeration;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.RequestDispatcher;

/**
 *
 * @author aless
 */
public class Purchase_Servlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }

@Override
protected void doPost(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {
    Enumeration<String> parameterNames = request.getParameterNames();
    InventoryBusinessLogic inventoryBusinessLogic = new InventoryBusinessLogic();

    while (parameterNames.hasMoreElements()) {
        String paramName = parameterNames.nextElement();
        if (paramName.startsWith("itemQTD_")) {
            String paramValue = request.getParameter(paramName);
            if (!paramValue.isEmpty()) {
                int itemId = Integer.parseInt(paramName.substring("itemQTD_".length()));
                int quantity = Integer.parseInt(paramValue);
                if (quantity > 0) {
                    inventoryBusinessLogic.updateInventory_ReduceQuantity(itemId, quantity);
                }
            }
        }
    }
    // Redirect or forward back to the purchase.jsp page
    RequestDispatcher dispatcher = request.getRequestDispatcher("/Views/Purchase.jsp");
    dispatcher.forward(request, response);

}

    @Override
    public String getServletInfo() {
        return "Purchase Servlet";
    }// </editor-fold>

}
