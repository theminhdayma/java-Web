<%@ page import="com.data.session03.Order" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>Order Form</title>
</head>
<body>
<%
    String method = request.getMethod();
    if ("POST".equalsIgnoreCase(method)) {
        String product = request.getParameter("product");
        int quantity = Integer.parseInt(request.getParameter("quantity"));
        double price = Double.parseDouble(request.getParameter("price"));

        Order order = new Order(product, quantity, price);
        double total = order.calculateTotal();
%>
<h2>Order Summary</h2>
<p>Product: <strong><%= order.getProduct() %></strong></p>
<p>Quantity: <%= order.getQuantity() %></p>
<p>Price per unit: $<%= order.getPricePerUnit() %></p>
<p><strong>Total Price: $<%= total %></strong></p>
<br>
<%
} else {
%>
<h2>Order Form</h2>
<form method="post">
    Product: <input type="text" name="product" required /><br/><br/>
    Quantity: <input type="number" name="quantity" required /><br/><br/>
    Price per Unit: <input type="number" step="0.01" name="price" required /><br/><br/>
    <input type="submit" value="Submit" />
</form>
<%
    }
%>
</body>
</html>
