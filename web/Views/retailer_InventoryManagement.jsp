<%-- 
    Document   : retailer_InventoryManagement
    Created on : Apr. 9, 2024, 1:09:14 p.m.
    Author     : aless
--%>

<%@page import="java.util.Map"%>
<%@page import="Model.Inventory"%>
<%@page import="Model.Discount"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="Model.Item"%>
<%@page import="java.util.List"%>
<%@page import="BusinessLayer.ItemBusinessLogic"%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Inventory Management</title>
        <link rel="stylesheet" href="CSS/style.css" type="text/css"/>
    </head>
    <body>
        <header>
            <h1>Inventory Management</h1>
            <div class="inventory-nav">
                <nav>
                    <ul>
                       <li><a href="Retailer_InventoryManagement_Servlet?action=RetailerHome">Retailer Home</a></li>
                        <li><a href="Retailer_InventoryManagement_Servlet?action=surplus">Surplus Food</a></li>
                        <li><a href="index.html">Logout</a></li>
                    </ul>
                </nav>
            </div>
        </header>
        <main>
            <section class="add-item-section">
                <h2>Add New Item</h2>
                <form method="POST" action="Retailer_InventoryManagement_Servlet?button=addItem">
                    <div class="form-group">
                        <label for="name">Name:</label>
                        <input type="text" id="name" name="name" required>
                    </div>
                    <div class="form-group">
                        <label for="description">Description:</label>
                        <input type="text" id="description" name="description" required>
                    </div>
                    <div class="form-group">
                        <label for="price">Price:</label>
                        <input type="text" id="price" name="price" required>
                    </div>
                    <div class="form-group">
                        <label for="expiration">Expiration Date:</label>
                        <input type="date" id="expiration" name="expiration" required>
                    </div>
                    <button type="submit" class="button">Add Item</button>
                </form>
            </section>
            <section class="update-quantity-section">
                <h2>Update Item</h2>
                <form method="POST" action="Retailer_InventoryManagement_Servlet?button=updateItem">
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
                    <div class="form-group">
                        <label for="donation">For Donation:</label>
                        <input type="checkbox" id="donation" name="donation">
                    </div>
                    <button type="submit" class="button">Update</button>
                </form>
            </section>
        </form>
        <section id="inventory-list" class="inventory-list-section">
            <h2>Inventory List</h2>
            <br>
            <form method="POST" action="UpdateItem_Servlet">
                <table>
                    <tr>
                        <th>Item Id</th> 
                        <th>Name</th>
                        <th>Description</th>
                        <th>Price</th>
                        <th>Expiration Date</th>
                        <th>Discount</th>
                        <th>For Donation</th>
                        <th> Add Quantity</th>
                    </tr>
                    <%
                        ItemBusinessLogic itemBusinessLogic = new ItemBusinessLogic();
                        List<Item> itemsList = itemBusinessLogic.getAllItems();

                        for (Item item : itemsList) {
                    %>
                    <tr>

                        <td><%= item.getItem_id()%></td>
                        <td><%= item.getName()%></td>
                        <td><%= item.getDescription()%></td>
                        <td><%= item.getPrice()%></td>
                        <td><%= item.getExpirationDate()%></td>
                        <td><%= Discount.getDiscountDescriptionById(item.getDiscount_id())%></td>
                        <td><%= item.isForDonation() ? "Yes" : "No"%></td>
                        <td><input type="number" name="itemQTD_<%= item.getItem_id()%>" value=""></td>
                        <td><input type="hidden" name="itemId_<%= item.getItem_id()%>" value="<%= item.getItem_id()%>"></td>


                    </tr>
                    <% }%>

                </table>
                <button type="submit" class="button">Update</button>
            </form>

        </section>
    </main>
    <footer>
        <p>&copy; 2024 Food Waste Reduction Platform. All rights reserved.</p>
    </footer>
</body>
</html>