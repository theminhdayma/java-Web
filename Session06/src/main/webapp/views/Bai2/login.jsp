<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
    <title>Đăng Nhập</title>
</head>
<body>
<h2>Đăng Nhập</h2>

<c:if test="${not empty error}">
    <p style="color: red;">${error}</p>
</c:if>

<c:if test="${not empty message}">
    <p style="color: green;">${message}</p>
</c:if>

<form action="login" method="POST">
    <label for="username">Tên đăng nhập:</label><br>
    <input type="text" id="username" name="username" required><br><br>

    <label for="password">Mật khẩu:</label><br>
    <input type="password" id="password" name="password" required><br><br>

    <button type="submit">Đăng nhập</button>
</form>

<br><br>
<a href="register">Chưa có tài khoản? Đăng ký ngay!</a>
</body>
</html>
