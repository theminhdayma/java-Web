<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head><title>Giỏ hàng</title></head>
<body>
<h2>Giỏ hàng của bạn</h2>
<a href="products">← Tiếp tục mua hàng</a>
<c:if test="${empty cart}">
    <p>Giỏ hàng trống.</p>
</c:if>
<c:if test="${not empty cart}">
    <table border="1">
        <tr>
            <th>Tên</th>
            <th>Giá</th>
            <th>Số lượng</th>
            <th>Tổng</th>
            <th>Hành động</th>
        </tr>
        <c:forEach var="item" items="${cart}">
            <tr>
                <td>${item.product.name}</td>
                <td>${item.product.price}</td>
                <td>${item.quantity}</td>
                <td>${item.product.price * item.quantity}</td>
                <td>
                    <a href="cart/increase?id=${item.product.id}">Thêm</a>
                    <a href="cart/decrease?id=${item.product.id}">Bớt</a>
                    <a href="cart/remove?id=${item.product.id}">Xoá</a>
                </td>
            </tr>
        </c:forEach>
    </table>
    <h3>Tổng cộng: ${total}</h3>
</c:if>
</body>
</html>