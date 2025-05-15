<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
  <title>Title</title>
</head>
<body>
<h2>Danh sách góp ý</h2>
<table border="1">
  <tr>
    <th>Họ tên</th>
    <th>SĐT</th>
    <th>Địa chỉ</th>
    <th>Nội dung</th>
  </tr>
  <c:forEach var="feed" items="${feedbackList}">
    <tr>
      <td>${feed.name}</td>
      <td>${feed.phone}</td>
      <td>${feed.address}</td>
      <td>${feed.content}</td>
    </tr>
  </c:forEach>
</table>

</body>
</html>