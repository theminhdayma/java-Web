<%@ page contentType="text/html; charset=UTF-8" %>
<html>
<head><title>Thêm nhân viên</title></head>
<body>
<h2>Thêm nhân viên</h2>
<form action="employee" method="post">
  <input type="text" name="name" placeholder="Tên" required><br>
  <input type="date" name="birthday" required><br>
  <input type="text" name="phone" placeholder="Số điện thoại" required><br>
  <input type="email" name="email" placeholder="Email" required><br>
  <input type="number" name="salary" placeholder="Lương" required><br>
  <input type="text" name="position" placeholder="Chức vụ" required><br>
  <input type="hidden" name="action" value="add">
  <button type="submit">Thêm</button>
</form>
</body>
</html>
