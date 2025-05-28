<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
  <title>Đăng nhập</title>
</head>
<body>
<h2>Đăng nhập</h2>
<form action="login" method="post">
  Tên người dùng: <input type="text" name="username"><br><br>
  Mật khẩu: <input type="password" name="password"><br><br>
  <input type="submit" value="Đăng nhập">
</form>
<p style="color:red">${error}</p>
</body>
</html>
