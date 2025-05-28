<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>Sửa đơn hàng</title>
</head>
<body>
<h2>Sửa đơn hàng</h2>
<form action="${pageContext.request.contextPath}/orders/edit" method="post">
    <label>Mã đơn hàng:</label><br/>
    <input type="text" name="orderId" value="${order.orderId}" readonly/><br/><br/>

    <label>Tên sản phẩm:</label><br/>
    <input type="text" name="productName" value="${order.productName}" required/><br/><br/>

    <label>Số lượng:</label><br/>
    <input type="number" name="quantity" value="${order.quantity}" min="1" required/><br/><br/>

    <button type="submit">Cập nhật</button>
</form>
<br/>
<a href="${pageContext.request.contextPath}/orders">Quay lại danh sách</a>
</body>
</html>
