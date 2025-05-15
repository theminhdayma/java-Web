<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Kết quả Oẳn Tù Tì</title>
</head>
<body>
<h1>Oẳn Tù Tì - Kết quả</h1>
<p><strong>Chọn của bạn:</strong> <%= request.getAttribute("userChoice") %></p>
<p><strong>Lựa chọn của máy tính:</strong> <%= request.getAttribute("computerChoice") %></p>
<p><strong>Kết quả:</strong> <%= request.getAttribute("result") %></p>

<a href="Bai5Controller">Chơi lại</a>
</body>
</html>