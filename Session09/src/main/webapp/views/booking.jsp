<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head><title>Đặt vé</title></head>
<body>
<h2>Chọn ghế để đặt vé</h2>

<c:if test="${not empty error}">
  <p style="color:red">${error}</p>
</c:if>

<form action="${pageContext.request.contextPath}/tickets/book" method="post">
  <input type="hidden" name="scheduleId"   value="${scheduleId}" />
  <input type="hidden" name="screenRoomId" value="${screenRoomId}" />

  <table border="1" cellpadding="5">
    <thead>
    <tr><th>Ghế</th><th>Trạng thái</th><th>Chọn</th></tr>
    </thead>
    <tbody>
    <c:forEach var="seat" items="${seats}">
      <tr>
        <td>${seat.seatNumber}</td>
        <td>
          <c:choose>
            <c:when test="${bookedSeats.contains(seat.id)}">
              Đã đặt
            </c:when>
            <c:otherwise>
              Trống
            </c:otherwise>
          </c:choose>
        </td>
        <td>
          <c:if test="${not bookedSeats.contains(seat.id)}">
            <input type="radio" name="seatId" value="${seat.id}" required/>
          </c:if>
        </td>
      </tr>
    </c:forEach>
    </tbody>
  </table>

  <p>
    <label>Giá vé:</label>
    <input type="number" name="price" step="0.01" required/>
  </p>

  <button type="submit">Đặt vé</button>
</form>

<c:if test="${not empty message}">
  <p style="color:green">${message}</p>
</c:if>
</body>
</html>
