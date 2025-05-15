<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <title>Nhap thong tin nguoi dung</title>
</head>
<body>
<h2>Nhap thong tin nguoi dung</h2>
<form action="UserInfoServlet" method="post">
  <label for="name">Ten:</label>
  <input type="text" id="name" name="name" required><br><br>

  <label for="age">Tuoi:</label>
  <input type="number" id="age" name="age" required><br><br>

  <button type="submit">Gui</button>
</form>
</body>
</html>
