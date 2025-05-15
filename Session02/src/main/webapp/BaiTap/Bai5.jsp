<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="vi">
<head>
    <meta charset="UTF-8">
    <title>Thong tin nguoi dung</title>
</head>
<body>
<h2>Thong tin dang ky</h2>
<p><strong>Ten:</strong> <%= request.getAttribute("username") %></p>
<p><strong>Email:</strong> <%= request.getAttribute("email") %></p>
<p><strong>Mat khau:</strong> <%= request.getAttribute("password") %></p>
</body>
</html>
