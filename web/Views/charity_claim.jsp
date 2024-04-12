<%-- 
    Document   : Purchase
    Created on : Apr. 11, 2024, 4:36:10 p.m.
    Author     : aless
--%>

<%@page import="Model.DonationItems"%>
<%@page import="Model.General_Items_Inventory"%>
<%@page import="Model.SalesItems"%>
<%@page import="java.util.List"%>
<%@page import="BusinessLayer.InventoryBusinessLogic"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Purchase Surplus Food</title>
        <link rel="stylesheet" href="<%= request.getContextPath()%>/CSS/style.css" type="text/css"/>
        <style>
                  table {
                width: max-content;
            }

            .inventory-list-section {
                display: flex;
                flex-direction: column;
                max-width: 300%;
                overflow-x: auto;
            }

            .inventory-list-section table {
                width: max-content;
                height: auto;
                display: inline-block;
                font-size: 14px;
            }

            .inventory-list-section th{
                padding: 10px;
            }

            .inventory-list-section td {
                text-align: center;
                border-bottom: 1px solid #ddd;
            }

            .inventory-list-section th {
                background-color: #f2f2f2;
            }
            .inventory-list-section input[type="number"] {
                width: 70px;
                display: inline-block;
            }

        </style>

    </head>
    <body>
        <header>
            <h1>Purchase Surplus Food</h1>
            <div class="purchase-nav">
                <nav>
                    <ul>
                        <li><a href="Charity_Servlet?action=CharityHome">Charity Home</a></li>
                        <li><a href="Charity_Servlet?action=Claim">Claim Donation Items</a></li>
                          <li><a href="Subscription_Servlet">Subscription</a></li>
                        <li><a href="Charity_Servlet?action=Logout">Logout</a></li>
                    </ul>
                </nav>
            </div>
        </header>
        <main>
            <section id="inventorylist" class="inventory-list-section">
                <h2>Items</h2>
                <form action="Charity_Servlet" method="post">
                    <div class="table-container" >
                        <table>
                            <thead>
                                <tr>
                                    <th>Item Id</th>
                                    <th>Name</th>
                                    <th>Description</th>
                                    <th>Price</th>
                                    <th>Expiration Date</th>
                                    <th>In Stock</th>
                                    <th>Quantity</th>
                                </tr>
                            </thead>
                            <tbody>
                                <% InventoryBusinessLogic inventoryLogic = new InventoryBusinessLogic();
                                    List<DonationItems> donationItemses = inventoryLogic.getDonationItems();
                                    for (DonationItems donationItem : donationItemses) {%>

                                <tr>
                                    <td><%= donationItem.getItemId()%></td>
                                    <td><%= donationItem.getName()%></td>
                                    <td><%= donationItem.getDescription()%></td>
                                    <td><%= donationItem.getPrice()%></td>
                                    <td><%= donationItem.getExpirationDate()%></td>
                                    <td><%= donationItem.getQuantity()%></td>

                                    <td><input type="number" name="itemQTD_<%= donationItem.getItemId()%>" value=""></td>
                                </tr>
                                <% }%>
                            </tbody>
                        </table>
                    </div>
                    <div class="button-container">
                        <button type="submit" class="add-to-cart-button"> Claim</button>
                    </div>
                </form>
            </section>


        </main>
        <footer>
            <p>&copy; 2024 Food Waste Reduction Platform. All rights reserved.</p>
        </footer>
    </body>
</html>