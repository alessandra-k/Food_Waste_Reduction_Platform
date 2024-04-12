<%-- 
    Document   : cart
    Created on : Apr. 11, 2024, 9:45:22 p.m.
    Author     : aless
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>Shopping Cart</title>
</head>
<body>
    <h1>Your Shopping Cart</h1>
    <ul>
        <c:forEach items="${selectedItems}" var="item">
            <li>
                <strong>Item Id:</strong> ${item.itemId}<br>
                <strong>Name:</strong> ${item.name}<br>
                <strong>Description:</strong> ${item.description}<br>
                <strong>Price:</strong> ${item.price}<br>
                <strong>Expiration Date:</strong> ${item.expirationDate}<br>
                <strong>Quantity ORDERED not in stock:</strong> ${item.quantity}<br> <!-- Quantity ORDERED not in stock -->
                <strong>Discount Description:</strong> ${item.discountDescription}<br>
            </li>
        </c:forEach>
    </ul>
</body>
</html>
