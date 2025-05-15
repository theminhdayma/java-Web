<%@ page import="java.util.*" %>
<%@ page import="com.data.session03.Product" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    List<Product> productList = (List<Product>) application.getAttribute("productList");
    if (productList == null) {
        productList = new ArrayList<>();
        application.setAttribute("productList", productList);
    }

    String method = request.getMethod();
    if ("POST".equalsIgnoreCase(method)) {
        int id = Integer.parseInt(request.getParameter("id"));
        String name = request.getParameter("productName");
        double price = Double.parseDouble(request.getParameter("price"));
        String desc = request.getParameter("description");
        int stock = Integer.parseInt(request.getParameter("stock"));

        Product p = new Product(id, name, price, desc, stock);
        productList.add(p);
    }
%>
<!DOCTYPE html>
<html>
<head>
    <title>Quản Lý Sản Phẩm</title>
    <style>
        body { font-family: Arial; margin: 20px; }
        input, button { margin: 5px 0; width: 100%; padding: 8px; }
        table { border-collapse: collapse; width: 100%; margin-top: 20px; }
        table, th, td { border: 1px solid #ddd; }
        th, td { padding: 10px; text-align: left; }
    </style>
</head>
<body>
<h2>Quản Lý Sản Phẩm</h2>
<form method="post">
    <label>ID</label><input type="text" name="id" required />
    <label>Tên sản phẩm</label><input type="text" name="productName" required />
    <label>Giá</label><input type="text" name="price" required />
    <label>Mô tả</label><input type="text" name="description" required />
    <label>Số lượng</label><input type="text" name="stock" required />
    <button type="submit">Thêm sản phẩm</button>
</form>

<h3>Danh sách sản phẩm đã thêm:</h3>
<table>
    <tr>
        <th>ID</th><th>Tên sản phẩm</th><th>Giá</th><th>Mô tả</th><th>Số lượng</th><th>Trạng thái</th>
    </tr>
    <%
        for (Product p : productList) {
    %>
    <tr>
        <td><%= p.getId() %></td>
        <td><%= p.getProductName() %></td>
        <td><%= p.getPrice() %></td>
        <td><%= p.getDescription() %></td>
        <td><%= p.getStock() %></td>
        <td><%= p.getStatus() %></td>
    </tr>
    <%
        }
    %>
</table>
</body>
</html>
