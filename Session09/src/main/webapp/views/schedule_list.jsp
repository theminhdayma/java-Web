<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8">
  <title>Lịch chiếu phim</title>
  <style>
    table { border-collapse: collapse; }
    th, td { border: 1px solid #333; padding: 8px; }
  </style>
</head>
<body>
<h2>Lịch chiếu phim cho phim ID: ${movieId}</h2>

<c:if test="${empty schedules}">
  <p>Hiện tại chưa có lịch chiếu cho phim này.</p>
</c:if>

<c:if test="${not empty schedules}">
  <table>
    <thead>
    <tr>
      <th>ID lịch chiếu</th>
      <th>Tiêu đề phim</th>
      <th>Thời gian chiếu</th>
      <th>ID phòng chiếu</th>
      <th>Số ghế trống</th>
      <th>Action</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach var="schedule" items="${schedules}">
      <tr>
        <td>${schedule.id}</td>
        <td>${schedule.movieTitle}</td>
        <td>
"${schedule.showTime}"
        </td>
        <td>${schedule.screenRoomId}</td>
        <td>${schedule.availableSeats}</td>
          <td>
              <c:url var="bookingUrl" value="/tickets/booking">
                  <c:param name="scheduleId" value="${schedule.id}" />
                  <c:param name="screenRoomId" value="${schedule.screenRoomId}" />
              </c:url>
              <a href="${bookingUrl}">Đặt vé</a>
          </td>
      </tr>
    </c:forEach>
    </tbody>
  </table>
</c:if>
</body>
</html>
