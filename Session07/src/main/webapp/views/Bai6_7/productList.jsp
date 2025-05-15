<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head><title>Danh sách sản phẩm</title></head>
<body>
<h2>Danh sách sản phẩm</h2>
<a href="cart">🛒 Xem giỏ hàng</a>
<c:if test="${not empty error}">
    <p style="color:red">${error}</p>
</c:if>
<table border="1">
    <tr>
        <th>Hình ảnh</th>
        <th>Tên</th>
        <th>Giá</th>
        <th>Số lượng</th>
        <th>Hành động</th>
    </tr>
    <c:forEach var="product" items="${products}">
        <tr>
            <td><img src="${product.image}" width="100"/></td>
            <td>${product.name}</td>
            <td>${product.price}</td>
            <td>${product.stock}</td>
            <td>
                <form action="cart/add" method="post">
                    <input type="hidden" name="id" value="${product.id}"/>
                    <input type="number" name="quantity" min="1" value="1" style="width:50px"/>
                    <button type="submit">Thêm vào giỏ</button>
                </form>
                <a href="products/details?id=${product.id}">Xem chi tiết</a>
            </td>
        </tr>
    </c:forEach>
</table>
</body>
</html>