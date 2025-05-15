<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Kết quả đăng ký</title>
</head>
<body>
<%
    String status = (String) request.getAttribute("status");
    if ("success".equals(status)) {
%>
<h2>Đăng ký vé xe thành công!</h2>
<p>Họ và tên: <%= request.getAttribute("fullName") %></p>
<p>Lớp: <%= request.getAttribute("className") %></p>
<p>Loại xe: <%= request.getAttribute("vehicleType") %></p>
<p>Biển số xe: <%= request.getAttribute("plateNumber") %></p>
<%
} else {
%>
<h2>Đăng ký thất bại. Vui lòng điền đầy đủ thông tin.</h2>
<%
    }
%>
</body>
</html>