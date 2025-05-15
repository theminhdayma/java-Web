<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Đăng ký vé xe</title>
</head>
<body>
<h2>Form Đăng Ký Vé Xe</h2>
<form action="RegisterTicket" method="post">
    <label>Họ và tên:</label><br>
    <input type="text" name="fullName" required><br><br>

    <label>Lớp:</label><br>
    <input type="text" name="className" required><br><br>

    <label>Loại xe:</label><br>
    <input type="text" name="vehicleType" required><br><br>

    <label>Biển số xe:</label><br>
    <input type="text" name="plateNumber" required><br><br>

    <button type="submit">Đăng ký</button>
</form>
</body>
</html>
