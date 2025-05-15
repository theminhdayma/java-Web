<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
    <title>Đăng Ký</title>
</head>
<body>
<h2>Đăng Ký</h2>

<form action="register" method="POST">
    <label for="username">Tên đăng nhập:</label><br>
    <input type="text" id="username" name="username"><br><br>

    <label for="password">Mật khẩu:</label><br>
    <input type="password" id="password" name="password"><br><br>

    <label for="email">Email:</label><br>
    <input type="email" id="email" name="email"><br><br>

    <label for="phone">Số điện thoại:</label><br>
    <input type="text" id="phone" name="phone"><br><br>

    <button type="submit">Đăng ký</button>
</form>

<br><br>
<a href="login">Đã có tài khoản? Đăng nhập ngay!</a>
</body>
</html>
