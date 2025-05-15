<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
  <title>Trang chủ</title>
</head>
<body>
<h2>Trang chủ</h2>
<form method="post">
  <button type="submit">Đến trang chào mừng</button>
</form>

<%
  if ("POST".equalsIgnoreCase(request.getMethod())) {
%>
<jsp:forward page="result.jsp" />
<%
  }
%>
</body>
</html>
