<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>Thêm đơn hàng</title>
</head>
<body>
<h2>Thêm đơn hàng mới</h2>
<form action="${pageContext.request.contextPath}/orders/add" method="post">
    <label>Mã đơn hàng:</label><br/>
    <input type="text" name="orderId" required/><br/><br/>

    <label>Tên sản phẩm:</label><br/>
    <input type="text" name="productName" required/><br/><br/>

    <label>Số lượng:</label><br/>
    <input type="number" name="quantity" min="1" required/><br/><br/>

    <button type="submit">Thêm</button>
</form>
<br/>
<a href="${pageContext.request.contextPath}/orders">Quay lại danh sách</a>
</body>
</html>
