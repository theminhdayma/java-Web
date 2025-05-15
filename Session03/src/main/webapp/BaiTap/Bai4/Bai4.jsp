<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
  <title>Phép Cộng Hai Số</title>
</head>
<body>
<h2>Nhập hai số để thực hiện phép cộng</h2>

<form method="get">
  Số thứ nhất: <input type="number" name="num1" required><br><br>
  Số thứ hai: <input type="number" name="num2" required><br><br>
  <input type="submit" value="Tính tổng">
</form>

<%
  String num1Str = request.getParameter("num1");
  String num2Str = request.getParameter("num2");

  if (num1Str != null && num2Str != null) {
    try {
      int num1 = Integer.parseInt(num1Str);
      int num2 = Integer.parseInt(num2Str);
%>
<h3>Tổng: <%= num1 + num2 %></h3>
<%
} catch (NumberFormatException e) {
%>
<p style="color:red;">Vui lòng nhập số hợp lệ.</p>
<%
    }
  }
%>
</body>
</html>
