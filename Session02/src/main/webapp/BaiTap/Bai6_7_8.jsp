<%@ page contentType="text/html;charset=UTF-8" %>
<%@ page import="java.util.*, com.data.session02.Product" %>
<!DOCTYPE html>
<html>
<head>
    <title>Danh Sách Sản Phẩm</title>
    <style>
        .container {
            display: flex;
            flex-direction: column;
            align-items: center;
            gap: 30px;
        }
        table, th, td {
            border: 1px solid black;
            border-collapse: collapse;
            padding: 8px;
        }
        form {
            margin-bottom: 20px;
        }
    </style>
</head>
<body>
<div class="container">
    <h1>Danh Sách Sản Phẩm</h1>

    <% Product editProduct = (Product) request.getAttribute("editProduct"); %>
    <div style="border: 1px solid black; width: 400px; padding: 10px;">
        <h2><%= (editProduct != null) ? "Sửa Sản Phẩm" : "Thêm Sản Phẩm" %></h2>
        <form action="ProductServlet" method="post">
            <% if (editProduct != null) { %>
            <input type="hidden" name="action" value="update">
            <input type="hidden" name="id" value="<%= editProduct.getId() %>">
            <% } %>
            Tên: <input type="text" name="name" value="<%= (editProduct != null) ? editProduct.getName() : "" %>" required><br><br>
            Giá: <input type="number" name="price" value="<%= (editProduct != null) ? editProduct.getPrice() : "" %>" required><br><br>
            <button type="submit"><%= (editProduct != null) ? "Cập Nhật" : "Thêm" %></button>
        </form>
    </div>

    <table>
        <tr>
            <th>ID</th>
            <th>Tên Sản Phẩm</th>
            <th>Giá</th>
            <th>Hành động</th>
        </tr>
        <%
            List<Product> list = (List<Product>) request.getAttribute("productList");
            if (list != null) {
                for (Product p : list) {
        %>
        <tr>
            <td><%= p.getId() %></td>
            <td><%= p.getName() %></td>
            <td><%= p.getPrice() %></td>
            <td>
                <a href="ProductServlet?action=edit&id=<%= p.getId() %>"><button>Sửa</button></a>
                <form action="ProductServlet" method="post" style="display:inline;">
                    <input type="hidden" name="action" value="delete">
                    <input type="hidden" name="id" value="<%= p.getId() %>">
                    <button type="submit" onclick="return confirm('Bạn có chắc muốn xóa?');">Xóa</button>
                </form>
            </td>
        </tr>
        <%
                }
            }
        %>
    </table>
</div>
</body>
</html>
