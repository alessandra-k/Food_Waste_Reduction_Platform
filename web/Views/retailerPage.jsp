<%-- 
    Document   : retailerPage
    Created on : Mar. 22, 2024, 1:47:41 p.m.
    Author     : aless
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Welcome Retailer</title>
        <link rel="stylesheet" href="CSS/style.css" type="text/css"/>
    </head>
    <body>
        <header>
            <h1>Welcome Retailer</h1>
            <div class="navigation-bar">
                <nav>
                    <ul>
                        <li><a href="Retailer_InventoryManagement_Servlet?action=Inventory">Inventory</a></li>
                        <li><a href="Retailer_InventoryManagement_Servlet?action=surplus">Surplus Food</a></li>
                        <li><a href="#">Logout</a></li>
                    </ul>
                </nav>
            </div>

        </header>
        <main>
            <section class="welcome-section">
                <h2>Welcome to Our Food Waste Reduction Platform!</h2>
                <p>As a retailer, you play a crucial role in preventing food waste. Manage your inventory, identify surplus food, and contribute to a more sustainable future.</p>
            </section>
            <section class="features-section">
                <h2>Features:</h2>
                <ul>
                    <li>Add new items</li>
                    <li>Update quantities</li>
                    <li>Set expiration dates</li>
                    <li>Flag surplus food items</li>
                    <li>List surplus food for donation or sale</li>
                </ul>
            </section>
        </main>
        <footer>
            <p>&copy; 2024 Food Waste Reduction Platform. All rights reserved.</p>
        </footer>
    </body>
</html>
