<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.*" %>
<%@ page import="com.data.session04.Bai7.Product" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%
    List<Product> products = new ArrayList<>();
    products.add(new Product(1, "Áo thun", 150000));
    products.add(new Product(2, "Quần jeans", 350000));
    products.add(new Product(3, "Giày thể thao", 800000));
    products.add(new Product(4, "Mũ lưỡi trai", 100000));
    products.add(new Product(5, "Ba lô", 250000));

    String minParam = request.getParameter("min");
    String maxParam = request.getParameter("max");

    Double minPrice = (minParam != null && !minParam.isEmpty()) ? Double.parseDouble(minParam) : null;
    Double maxPrice = (maxParam != null && !maxParam.isEmpty()) ? Double.parseDouble(maxParam) : null;

    List<Product> filteredProducts = new ArrayList<>();
    for (Product p : products) {
        boolean isValid = true;
        if (minPrice != null && p.getPrice() < minPrice) {
            isValid = false;
        }
        if (maxPrice != null && p.getPrice() > maxPrice) {
            isValid = false;
        }
        if (isValid) {
            filteredProducts.add(p);
        }
    }

    request.setAttribute("products", filteredProducts);
    request.setAttribute("hasResult", !filteredProducts.isEmpty());
%>

<html>
<head>
    <title>Lọc sản phẩm theo giá</title>
    <style>
        table { border-collapse: collapse; width: 60%; margin-top: 20px; }
        th, td { border: 1px solid black; padding: 8px; text-align: center; }
        th { background-color: #f2f2f2; }
        form { margin-bottom: 20px; }
    </style>
</head>
<body>
<h2>📦 Danh sách sản phẩm</h2>

<form method="get">
    Giá từ:
    <input type="number" name="min" value="${param.min}" />
    đến:
    <input type="number" name="max" value="${param.max}" />
    <button type="submit">Lọc</button>
</form>

<table>
    <tr>
        <th>ID</th>
        <th>Tên sản phẩm</th>
        <th>Giá (VNĐ)</th>
    </tr>
    <c:forEach var="p" items="${products}">
        <tr>
            <td>${p.id}</td>
            <td>${p.name}</td>
            <td>${p.price}</td>
        </tr>
    </c:forEach>
</table>

<c:if test="${!hasResult}">
    <p style="color:red; font-weight:bold">Không có sản phẩm nào trong khoảng giá này.</p>
</c:if>

</body>
</html>
