<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Danh sách sản phẩm</title>
</head>
<body>

<h2>Danh sách sản phẩm</h2>
<table border="1">
    <thead>
    <tr>
        <th>Tên sản phẩm</th>
        <th>Giá</th>
        <th>Thao tác</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach var="product" items="${products}">
        <tr>
            <td>${product.name}</td>
            <td>${product.price}</td>
            <td>
                <form action="ProductController" method="post">
                    <input type="hidden" name="productId" value="${product.id}">
                    <input type="hidden" name="userId" value="1">
                    Số lượng: <input type="number" name="quantity" min="1" value="1">
                    <input type="submit" value="addProductToCart">
                </form>
            </td>
        </tr>
    </c:forEach>
    </tbody>
</table>
<a href="CartController">Xem giỏ hàng</a>
</body>
</html>