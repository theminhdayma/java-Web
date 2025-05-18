<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ page contentType="text/html;charset=UTF-8" %>

<html>
<head>
    <title>Đặt Vé Rạp Phim</title>
</head>
<body>
<h2>Form Đặt Vé</h2>

<form action="bookTicket" method="post">
    <label>Phim:</label><br>
    <input type="text" name="movieTitle" required/><br><br>

    <label>Thời gian chiếu:</label><br>
    <input type="datetime-local" name="showTime" required/><br><br>

    <label>Chọn ghế (giả sử nhập số ghế cách nhau dấu phẩy):</label><br>
    <input type="text" name="seats" placeholder="A1,A2,B3" required/><br><br>

    <input type="submit" value="Đặt Vé"/>
</form>
</body>
</html>
