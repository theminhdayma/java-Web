<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<html>
<head><title>Thêm sản phẩm</title></head>
<body>
<h2>Thêm sản phẩm vào giỏ hàng</h2>
<form method="post" action="addCart">
    Tên sản phẩm: <input type="text" name="name" required><br>
    Số lượng: <input type="number" name="quantity" min="1" required><br>
    <button type="submit">Thêm</button>
</form>
<a href="cart">Xem giỏ hàng</a>
</body>
</html>
