<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" %>

<html>
<head>
    <title>Đăng Nhập</title>
</head>
<body>
<h2>Đăng Nhập</h2>

<c:if test="${not empty error}">
    <p style="color: red;">${error}</p>
</c:if>

<form action="${pageContext.request.contextPath}/login" method="post">
    Tên người dùng: <input type="text" name="username" required><br><br>
    Mật khẩu: <input type="password" name="password" required><br><br>
    <input type="submit" value="Đăng Nhập">
</form>
</body>
</html>
