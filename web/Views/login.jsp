<%-- 
    Document   : login
    Created on : Mar. 22, 2024, 1:46:57 p.m.
    Author     : aless
--%>

<% String error = (String) request.getAttribute("error");
    %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>User Login</title>
        <link rel="stylesheet" href="CSS/style.css" type="text/css"/>
    </head>
    <body>
        <header>
            <h1>User Login</h1>
            <p>Please enter your email address and password to log in.</p>
        </header>
        <main>
            <form class="login-form" action="Login_Servlet" method="POST">
                <div class="form-group">
                    <label for="email">Email Address:</label>
                    <input type="email" id="email" name="email" required>
                </div>
                <div class="form-group">
                    <label for="password">Password:</label>
                    <input type="password" id="password" name="password" required>
                </div>
                <button type="submit" class="button">Login</button>
                <p>   <% if (error != null) {
                out.print(error);
                    } %> </p>
            </form>

        </main>
        <footer>
            <p>&copy; 2024 Food Waste Reduction Platform. All rights reserved.</p>
        </footer>
    </body>
</html>
