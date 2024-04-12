<%-- 
    Document   : registration
    Created on : Mar. 22, 2024, 1:47:18 p.m.
    Author     : aless
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>User Registration</title>
   <link rel="stylesheet" href="CSS/style.css" type="text/css"/>
</head>
<body>
    <header>
        <h1>User Registration</h1>
        <p>Please fill out the form below to register.</p>
    </header>
    <main>
        <form class="registration-form" method="POST" action="Registration_Servlet">
            <div class="form-group">
                <label for="name">Name:</label>
                <input type="text" id="name" name="name" required>
            </div>
             <div class="form-group">
                <label for="address">Address Street:</label>
                <input type="text" id="address" name="address" required>
            </div>
                         <div class="form-group">
                <label for="postalCode">Postal Code:</label>
                <input type="text" id="postalCode" name="postalCode" required>
            </div>
                 <div class="form-group">
                <label for="phone">Phone:</label>
                <input type="text" id="phone" name="phone" required>
            </div>
            <div class="form-group">
                <label for="email">Email:</label>
                <input type="email" id="email" name="email" required>
            </div>
            <div class="form-group">
                <label for="password">Password:</label>
                <input type="password" id="password" name="password" required>
            </div>
            <div class="form-group">
                <label>User Type:</label>
                <div class="radio-buttons">
                    <input type="radio" id="retailer" name="user-type" value="RETAILER" required>
                    <label for="retailer">Retailer</label>
                    <input type="radio" id="consumer" name="user-type" value="CONSUMER" required>
                    <label for="consumer">Consumer</label>
                    <input type="radio" id="charity" name="user-type" value="CHARITY" required>
                    <label for="charity">Charity</label>
                </div>
            </div>
            <button type="submit" class="registrationbutton">Register</button>
        </form>
    </main>
    <footer>
        <p>&copy; 2024 Food Waste Reduction Platform. All rights reserved.</p>
    </footer>
</body>
</html>
