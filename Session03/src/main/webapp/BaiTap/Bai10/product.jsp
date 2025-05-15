<%@ page import="java.util.*" %>
<%@ page import="com.data.session03.bai10.Product" %>
<%@ page import="com.data.session03.bai10.CartManager" %>
<%
    List<Product> products = new ArrayList<>();
    products.add(new Product(1, "Ao thun", 100000));
    products.add(new Product(2, "Quan jeans", 200000));
    products.add(new Product(3, "Giay sneaker", 300000));

    CartManager cartManager = (CartManager) session.getAttribute("cartManager");
    if (cartManager == null) {
        cartManager = new CartManager();
        session.setAttribute("cartManager", cartManager);
    }

    String addId = request.getParameter("add");
    String message = null;
    if (addId != null) {
        int pid = Integer.parseInt(addId);
        for (Product p : products) {
            if (p.getId() == pid) {
                int beforeSize = cartManager.getCart().size();
                cartManager.addProduct(p);
                int afterSize = cartManager.getCart().size();
                if (beforeSize == afterSize) {
                    message = "San pham da ton tai trong gio hang!";
                } else {
                    message = "Them vao gio hang thanh cong!";
                }
                break;
            }
        }
    }
%>
<!DOCTYPE html>
<html>
<head><title>San pham</title></head>
<body>
<h2>Danh sach san pham</h2>
<% if (message != null) { %>
<p style="color:<%= message.contains("thanh cong") ? "green" : "red" %>"><%= message %></p>
<% } %>
<table border="1">
    <tr><th>ID</th><th>Ten</th><th>Gia</th><th>Hanh dong</th></tr>
    <% for (Product p : products) { %>
    <tr>
        <td><%= p.getId() %></td>
        <td><%= p.getName() %></td>
        <td><%= p.getPrice() %> VND</td>
        <td><a href="product.jsp?add=<%= p.getId() %>">Them vao gio</a></td>
    </tr>
    <% } %>
</table>
<br><a href="cart.jsp">Xem gio hang</a>
</body>
</html>
