<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
  <title>Thông tin cá nhân</title>
</head>
<body>
<h2>Nhập thông tin cá nhân</h2>
<form:form method="post" modelAttribute="user" action="submitForm" accept-charset="UTF-8">
  <label for="name">Họ và tên:</label>
  <form:input path="name" /><br/><br/>

  <label for="age">Tuổi:</label>
  <form:input path="age" /><br/><br/>

  <label for="address">Địa chỉ:</label>
  <form:input path="address" /><br/><br/>

  <input type="submit" value="Gửi" />
</form:form>
</body>
</html>
