<%@ page contentType="text/html;charset=UTF-8" %>
<%@ page import="java.util.*" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
    request.setCharacterEncoding("UTF-8");
    String username = request.getParameter("username");
    String password = request.getParameter("password");

    boolean isSubmitted = (username != null && password != null);
    boolean isValid = "admin".equals(username) && "123456".equals(password);

    request.setAttribute("isSubmitted", isSubmitted);
    request.setAttribute("isValid", isValid);
    request.setAttribute("username", username);
%>

<html>
<head>
    <title>Đăng Nhập</title>
</head>
<body>
<h2>Form Đăng Nhập</h2>
<form method="post">
    <label>Username:</label>
    <input type="text" name="username" required /><br/><br/>
    <label>Password:</label>
    <input type="password" name="password" required /><br/><br/>
    <input type="submit" value="Đăng Nhập" />
</form>

<c:if test="${isSubmitted}">
    <c:if test="${isValid}">
        <h3 style="color:green;">Đăng nhập thành công!</h3>
        <p>Chào mừng, ${username}!</p>
    </c:if>
    <c:if test="${!isValid}">
        <h3 style="color:red;">Đăng nhập thất bại. Vui lòng thử lại!</h3>
    </c:if>
</c:if>
</body>
</html>
