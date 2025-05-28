<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head><title>Login Page</title></head>
<body>
<h2>Login</h2>
<form action="loginBai7" method="post">
    Username: <input type="text" name="username" value="${username}" /><br/>
    Password: <input type="password" name="password" value="${password}" /><br/>
    <label><input type="checkbox" name="remember"/> Ghi nhớ tôi</label><br/>
    <input type="submit" value="Login"/>
</form>
<p style="color:red">${error}</p>
</body>
</html>
