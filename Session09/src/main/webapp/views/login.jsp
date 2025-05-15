<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
  <title>Login</title>
</head>
<body>
<h2>Đăng nhập</h2>

<form action="${pageContext.request.contextPath}/login" method="post">
  <label>Username:</label>
  <input type="text" name="username" required/><br/><br/>
  <label>Password:</label>
  <input type="password" name="password" required/><br/><br/>
  <button type="submit">Đăng nhập</button>
</form>

<c:if test="${not empty error}">
  <p style="color:red">${error}</p>
</c:if>

<p>Bạn chưa có tài khoản? <a href="${pageContext.request.contextPath}/register">Đăng ký</a></p>
</body>
</html>

