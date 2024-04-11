<%-- 
    Document   : SurplusItems_Management
    Created on : Apr. 11, 2024, 3:55:20 a.m.
    Author     : aless
--%>

<%@page import="Model.Item"%>
<%@page import="Model.ExcessDemandItems"%>
<%@page import="Model.DonationItems"%>
<%@page import="BusinessLayer.InventoryBusinessLogic"%>
<%@page import="Model.SalesItems"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">

        <title>Surplus Food Management</title>
        <link rel="stylesheet" href="CSS/style.css" type="text/css">
        <style>
    table {
        border-collapse: collapse;
        width: 90%; /* Set the table width to 80% of its container */
        margin: 0 auto; /* Center the table horizontally */
    }
    
    th, td {
        padding: 20px; /* Add padding to th and td */
        text-align: left; /* Align text to the left */
    }
    
    th {
        background-color: #f2f2f2; /* Add background color to table headers */
    }

    /* Adjust widths for other columns as needed */
</style>

    </head>
    <body>
        <header>
            <h1>Surplus Food Management - SALES</h1>
            <div class="surplus-food-nav">
                <nav>
                    <ul>
                        <li><a href="SurplusItems_Servlet?action=RetailerHome">Retailer Home</a></li>
                        <li><a href="SurplusItems_Servlet?action=InventoryManagement">Inventory Management</a></li>
                        <li><a href="SurplusItems_Servlet?action=ExcessDemandItems">Excess Demand Items</a></li>
                        <li><a href="SurplusItems_Servlet?action=ExpiringItems">Expiring Items</a></li>
                        <li><a href="SurplusItems_Servlet?action=Sales">Sales</a></li>
                        <li><a href="SurplusItems_Servlet?action=Donation">Donation</a></li>
                        <li><a href="SurplusItems_Servlet?action=Logout">Logout</a></li>
                    </ul>
                </nav>
            </div>

        </header>
        <main>
            
             <section class="update-quantity-section">
                <h2>Update Sale Item</h2>
                <form method="POST" action="SurplusItems_Servlet?button=updateSaleItem">
                    <div class="form-group">
                        <label for="itemID">Item ID:</label>
                        <input type="number" id="itemID" name="itemID" required>
                    </div>
                    <div class="form-group">
                        <label for="discount">Discount:</label>
                        <select id="discount" name="discount">
                            <option value="1">No Discount</option>
                            <option value="2">10% Discount</option>
                            <option value="3">20% Discount</option>
                            <option value="4">30% Discount</option>
                            <option value="5">40% Discount</option>
                            <option value="6">50% Discount</option>
                        </select>
                    </div>
             <button type="submit" class="button">Update</button>
                </form>
            </section>

            <section id="inventorylist" class="inventory-list-section">
                <h2>Sale Items List</h2>
                               <table>
                        <tr>
                            <th>Item Id</th>
                            <th>Name</th>
                            <th>Description</th>
                            <th>Price</th>
                            <th>Expiration Date</th>
                            <th>Quantity</th>
                            <th>Discount</th>
                        </tr>
                        </thead>
                        <tbody>
                            <% InventoryBusinessLogic inventoryLogic = new InventoryBusinessLogic();
                        List<SalesItems> salesItems = inventoryLogic.getItemsWithDiscount();
                        for (SalesItems salesItem : salesItems) {%>
                            <tr>
                                <td><%= salesItem.getItemId()%></td>
                                <td><%= salesItem.getName()%></td>
                                <td><%= salesItem.getDescription()%></td>
                                <td><%= salesItem.getPrice()%></td>
                                <td><%= salesItem.getExpirationDate()%></td>
                                <td><%= salesItem.getQuantity()%></td>
                                <td><%= salesItem.getDiscountDescription()%></td>
                            </tr>
                            <% }%>
                        </tbody>
                    </table>
     
                </form>

            </section>


        </main>
        <footer>
            <p>&copy; 2024 Food Waste Reduction Platform. All rights reserved.</p>
        </footer>
    </body>
</html>
