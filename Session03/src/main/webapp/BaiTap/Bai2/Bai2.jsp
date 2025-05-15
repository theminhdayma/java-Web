<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="vi">
<head>
    <meta charset="UTF-8">
    <title>Lưu thông tin người dùng</title>
</head>
<body>
<h2>Nhập thông tin người dùng</h2>
<form action="Bai2.jsp" method="post">
    <label for="name">Tên:</label><br>
    <input type="text" id="name" name="name" required><br><br>

    <label for="email">Email:</label><br>
    <input type="email" id="email" name="email" required><br><br>

    <button type="submit">Lưu thông tin</button>
</form>

<%
    String name = request.getParameter("name");
    String email = request.getParameter("email");

    if (name != null && email != null) {
        application.setAttribute("userName", name);
        application.setAttribute("userEmail", email);
%>
<h3>Đã lưu thông tin người dùng:</h3>
<p><strong>Tên:</strong> <%= name %></p>
<p><strong>Email:</strong> <%= email %></p>
<%
} else if (application.getAttribute("userName") != null) {
%>
<h3>Thông tin đã lưu:</h3>
<p><strong>Tên:</strong> <%= application.getAttribute("userName") %></p>
<p><strong>Email:</strong> <%= application.getAttribute("userEmail") %></p>
<%
    }
%>
</body>
</html>
