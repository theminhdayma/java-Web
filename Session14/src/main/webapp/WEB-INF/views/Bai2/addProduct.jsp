<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>Thêm Sản Phẩm</title>
</head>
<body>
<h2>Thêm sản phẩm</h2>
<form action="add" method="post">
    Mã sản phẩm: <input type="text" name="id"><br><br>
    Tên sản phẩm: <input type="text" name="name"><br><br>
    Giá: <input type="text" name="price"><br><br>
    <input type="submit" value="Thêm sản phẩm">
</form>
<br>
<a href="list">Xem danh sách sản phẩm</a>
</body>
</html>
