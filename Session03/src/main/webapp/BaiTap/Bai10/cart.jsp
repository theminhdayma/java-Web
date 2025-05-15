
<%@ page import="java.util.List" %>
<%@ page import="com.data.session03.bai10.CartManager" %>
<%@ page import="com.data.session03.bai10.Product" %>
<%
    CartManager cartManager = (CartManager) session.getAttribute("cartManager");
    if (cartManager == null) {
        cartManager = new CartManager();
        session.setAttribute("cartManager", cartManager);
    }

    String removeId = request.getParameter("remove");
    if (removeId != null) {
        int pid = Integer.parseInt(removeId);
        cartManager.removeProduct(pid);
    }

    List<Product> cart = cartManager.getCart();
    double total = cartManager.getTotalPrice();
%>
<!DOCTYPE html>
<html>
<head><title>Gio hang</title></head>
<body>
<h2>Gio hang cua ban</h2>
<table border="1">
    <tr><th>ID</th><th>Ten</th><th>Gia</th><th>Hanh dong</th></tr>
    <% for (Product p : cart) { %>
    <tr>
        <td><%= p.getId() %></td>
        <td><%= p.getName() %></td>
        <td><%= p.getPrice() %> VND</td>
        <td><a href="cart.jsp?remove=<%= p.getId() %>">Xoa</a></td>
    </tr>
    <% } %>
</table>
<p><strong>Tong tien:</strong> <%= total %> VND</p>
<br><a href="product.jsp">Quay lai san pham</a>
</body>
</html>
