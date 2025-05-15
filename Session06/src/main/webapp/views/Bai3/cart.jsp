
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Giỏ hàng</title>
</head>
<body>
<h2>Giỏ hàng của bạn</h2>

<table border="1" cellpadding="10" cellspacing="0">
    <tr>
        <th>ID Sản phẩm</th>
        <th>Tên sản phẩm</th>
        <th>Số lượng</th>
        <th>Giá</th>
        <th>Thành tiền</th>
        <th>Hành động</th>
    </tr>
    <c:set var="total" value="0" />
    <c:forEach var="item" items="${cartList}">
        <c:set var="itemTotal" value="${item.price * item.quantity}" />
        <tr>
            <td>${item.productId}</td>
            <td>${item.name}</td>
            <td>${item.quantity}</td>
            <td>${item.price}</td>
            <td>${itemTotal}</td>
            <td>
                <a href="CartController?action=remove&productId=${item.productId}">Xóa</a>
            </td>
        </tr>
        <c:set var="total" value="${total + itemTotal}" />
    </c:forEach>
    <tr>
        <td colspan="4" style="text-align:right;"><strong>Tổng cộng:</strong></td>
        <td colspan="2"><strong>${total}</strong></td>
    </tr>
</table>
</body>
</html>
