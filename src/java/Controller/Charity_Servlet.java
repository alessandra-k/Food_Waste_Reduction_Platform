package Controller;

import BusinessLayer.ClaimBusinessLogic;
import BusinessLayer.InventoryBusinessLogic;
import BusinessLayer.ItemBusinessLogic;
import DataAccessLayer.ClaimDAO;
import DataAccessLayer.ClaimDAOImpl;
import DataAccessLayer.ItemDAO;
import DataAccessLayer.ItemDAOImpl;
import Model.Claim;
import Model.DonationItems;
import Model.Item;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author aless
 */
public class Charity_Servlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action = request.getParameter("action");

        HttpSession session = request.getSession(false);
        if (session != null && session.getAttribute("user") != null) {
            switch (action) {
                case "CharityHome": {
                    request.getRequestDispatcher("/Views/charityPage.jsp").forward(request, response);
                    break;
                }
                case "Subscription": {
                    request.getRequestDispatcher("/Views/.jsp").forward(request, response);
                    break;
                }
                case "Claim": {
                    request.getRequestDispatcher("/Views/charity_claim.jsp").forward(request, response);
                    break;
                }
                default: {
                    request.getRequestDispatcher("/Views/login.jsp").forward(request, response);
                }
            }
        } else {

            request.getRequestDispatcher("/Views/login.jsp").forward(request, response);

        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {
    Enumeration<String> parameterNames = request.getParameterNames();
    List<DonationItems> claimedList = new ArrayList<>();
    while (parameterNames.hasMoreElements()) {
        String paramName = parameterNames.nextElement();
        if (paramName.startsWith("ItemClaimed_")) {
            // Extract item ID from parameter name
            int itemId = Integer.parseInt(paramName.substring("ItemClaimed_".length()));
            // Get quantity for the current item ID
            String quantityParam = request.getParameter(paramName);
            if (quantityParam != null && !quantityParam.isEmpty()) {
                int quantity = Integer.parseInt(quantityParam);
                // Create new DonationItems
                DonationItems itemClaimed = new DonationItems();
                ItemDAO itemDAO = new ItemDAOImpl();
                Item selectedItem = itemDAO.getItemById(itemId);
                itemClaimed.setItemId(selectedItem.getItem_id());
                itemClaimed.setName(selectedItem.getName());
                itemClaimed.setDescription(selectedItem.getDescription());
                itemClaimed.setExpirationDate(selectedItem.getExpirationDate());
                itemClaimed.setQuantity(quantity);

                claimedList.add(itemClaimed);
                InventoryBusinessLogic inventory = new InventoryBusinessLogic();
                inventory.updateInventory(itemId, quantity);
                
                
            }
        }
    }
    Claim claim = new Claim();
    claim.setClaimedItems(claimedList);
    
}


                @Override
                public String getServletInfo
                
                
                    () {
        return "Charity Servlet";
                }// </editor-fold>

            }
