<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h2>Góp ý thành công</h2>
<table border="1">
    <tr><td>Họ tên</td><td>${feedback.name}</td></tr>
    <tr><td>SĐT</td><td>${feedback.phone}</td></tr>
    <tr><td>Địa chỉ</td><td>${feedback.address}</td></tr>
    <tr><td>Nội dung</td><td>${feedback.content}</td></tr>
</table>

<a href="list">Xem danh sách góp ý</a>

</body>
</html>