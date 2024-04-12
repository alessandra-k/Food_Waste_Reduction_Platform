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
            <h1>Surplus Food Management</h1>
            <div class="surplus-food-nav">
                <nav>
                    <ul>
                        <li><a href="SurplusItems_Servlet?action=RetailerHome">Retailer Home</a></li>
                        <li><a href="SurplusItems_Servlet?action=InventoryManagement">Inventory Management</a></li>
                        <li><a href="SurplusItems_Servlet?action=ExcessDemandItems">Excess Demand Items</a></li>
                        <li><a href="SurplusItems_Servlet?action=ExpiringItems">Expiring Items</a></li>
                        <li><a href="SurplusItems_Servlet?action=Sales">Sales</a></li>
                        <li><a href="SurplusItems_Servlet?action=Donation">Donation</a></li>

                        <li><a href="index.html">Logout</a></li>


                    </ul>
                </nav>
            </div>

        </header>
        <main>
            <section id="inventorylist" class="inventory-list-section">
                <h2>Excess Demand Items</h2>
                <table>
                    <thead>
                        <tr>
                            <th>Name</th>
                            <th>Description</th>
                            <th>Price</th>
                            <th>Expiration Date</th>
                            <th>Quantity</th>
                        </tr>
                    </thead>
                    <tbody>
                        <%
                            InventoryBusinessLogic inventoryLogic = new InventoryBusinessLogic();
                            List<ExcessDemandItems> excessDemandItems = inventoryLogic.getItemsWithExcessDemand();

                            for (ExcessDemandItems item : excessDemandItems) {
                        %>
                        <tr>
                            <td><%= item.getName()%></td>
                            <td><%= item.getDescription()%></td>
                            <td><%= item.getPrice()%></td>
                            <td><%= item.getExpirationDate()%></td>
                            <td><%= item.getQuantity()%></td>
                        </tr>
                        <% }%>
                    </tbody>
                </table>
                    

            </section>
                    <a href="SurplusItems_Servlet?action=downloadPDF">Download PDF</a>


        </main>
        <footer>
            <p>&copy; 2024 Food Waste Reduction Platform. All rights reserved.</p>
        </footer>
    </body>
</html>
