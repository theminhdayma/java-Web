<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
  <title>Register</title>
</head>
<body>
<h2>Đăng ký tài khoản mới</h2>

<form action="${pageContext.request.contextPath}/register" method="post">
  <label>Username:</label>
  <input type="text" name="username" required/><br/><br/>
  <label>Password:</label>
  <input type="password" name="password" required/><br/><br/>
  <label>Email:</label>
  <input type="email" name="email" required/><br/><br/>
  <button type="submit">Đăng ký</button>
</form>

<c:if test="${not empty message}">
  <p style="color:green">${message}</p>
</c:if>

<p>Đã có tài khoản? <a href="${pageContext.request.contextPath}/login">Đăng nhập</a></p>
</body>
</html>
