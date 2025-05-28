<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.List" %>
<%@ page import="com.data.session14.model.Bai8.OrderItem" %>
<html>
<head><title>Danh sách đơn hàng</title></head>
<body>
<h2>Danh sách đơn hàng đã đặt</h2>

<% List<OrderItem> orders = (List<OrderItem>) request.getAttribute("orders"); %>
<% if (orders == null || orders.isEmpty()) { %>
<p>Chưa có đơn hàng nào.</p>
<% } else { %>
<table border="1">
    <tr>
        <th>Tên người dùng</th>
        <th>Sản phẩm</th>
        <th>Số lượng</th>
    </tr>
    <% for (OrderItem item : orders) { %>
    <tr>
        <td><%= item.getUsername() %></td>
        <td><%= item.getProduct() %></td>
        <td><%= item.getQuantity() %></td>
    </tr>
    <% } %>
</table>
<% } %>

<br>
<a href="orderBai8">Đặt thêm đơn hàng</a>
</body>
</html>
