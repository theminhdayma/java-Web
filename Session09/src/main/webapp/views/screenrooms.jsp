
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head><title>Danh sách phòng chiếu</title></head>
<body>
<h2>Danh sách phòng chiếu phim</h2>
<table border="1" cellpadding="5">
  <thead>
  <tr>
    <th>ID</th>
    <th>Tên phòng chiếu</th>
    <th>Số ghế</th>
  </tr>
  </thead>
  <tbody>
  <c:forEach var="room" items="${rooms}">
    <tr>
      <td>${room.id}</td>
      <td>${room.screenRoomName}</td>
      <td>${room.totalSeat}</td>
    </tr>
  </c:forEach>
  </tbody>
</table>
</body>
</html>
