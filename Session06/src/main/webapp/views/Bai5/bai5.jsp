
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Oẳn Tù Tì</title>
</head>
<body>
<h1>Chơi Oẳn Tù Tì</h1>
<form action="Bai5Controller" method="POST">
    <label for="choice">Chọn của bạn:</label>
    <select name="choice" id="choice">
        <option value="búa">Búa</option>
        <option value="lá">Lá</option>
        <option value="kéo">Kéo</option>
    </select>
    <button type="submit">Chơi</button>
</form>
</body>
</html>
