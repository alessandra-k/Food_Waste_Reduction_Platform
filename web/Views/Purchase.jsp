<%-- 
    Document   : Purchase
    Created on : Apr. 11, 2024, 4:36:10 p.m.
    Author     : aless
--%>

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
                        <li><a href="Purchase_Servlet?action=ConsumerHome">Consumer Home</a></li>
                        <li><a href="Purchase_Servlet?action=PurchasedItems"">Purchased Items</a></li>
                        <li><a href="Subscription_Servlet">Subscription</a></li>
                        <li><a href="index.html">Logout</a></li>
                    </ul>
                </nav>
            </div>
        </header>
        <main>
            <section id="inventorylist" class="inventory-list-section">
                <h2>Items</h2>
                <form action="Purchase_Servlet" method="post">
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
                                    <th>On SALE</th>
                                    <th>Quantity</th>
                                </tr>
                            </thead>
                            <tbody>
                                <% InventoryBusinessLogic inventoryLogic = new InventoryBusinessLogic();
                                    List<General_Items_Inventory> generalItems = inventoryLogic.getItemsAvailableForPurchase();
                                    for (General_Items_Inventory generalItem : generalItems) {%>

                                <tr>
                                    <td><%= generalItem.getItemId()%></td>
                                    <td><%= generalItem.getName()%></td>
                                    <td><%= generalItem.getDescription()%></td>
                                    <td><%= generalItem.getPrice()%></td>
                                    <td><%= generalItem.getExpirationDate()%></td>
                                    <td><%= generalItem.getQuantity()%></td>
                                    <td><%= generalItem.getDiscountDescription()%></td>
                                    <td><input type="number" name="itemQTD_<%= generalItem.getItemId()%>" value=""></td>
                                </tr>
                                <% }%>
                            </tbody>
                        </table>
                    </div>
                    <div class="button-container">
                        <button type="submit" class="add-to-cart-button"> Purchase</button>
                    </div>
                </form>
            </section>


        </main>
        <footer>
            <p>&copy; 2024 Food Waste Reduction Platform. All rights reserved.</p>
        </footer>
    </body>
</html>