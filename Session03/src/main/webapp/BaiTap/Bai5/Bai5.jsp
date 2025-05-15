<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>Đăng ký</title>
</head>
<body>

<%
    String method = request.getMethod();
    if ("POST".equalsIgnoreCase(method)) {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String email = request.getParameter("email");
%>
<div class="form-container">
    <div class="confirmation">
        Đăng ký thành công!<br/>
        Tên: <%= username %><br/>
        Email: <%= email %>
    </div>
</div>
<%
} else {
%>
<div class="form-container">
    <form method="post">
        <label>Username:</label>
        <input type="text" name="username" required>

        <label>Password:</label>
        <input type="password" name="password" required>

        <label>Email:</label>
        <input type="email" name="email" required>

        <input type="submit" value="Register">
    </form>
</div>
<%
    }
%>

</body>
</html>
