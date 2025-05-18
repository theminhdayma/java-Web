<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" %>

<html>
<head>
    <title>Thông Tin Vé Đặt</title>
</head>
<body>
<h2>Thông Tin Vé Đặt</h2>

<p><strong>Phim:</strong> ${ticket.movieTitle}</p>
<p><strong>Thời gian chiếu:</strong> ${ticket.showTime}</p>
<p><strong>Ghế đã chọn:</strong></p>
<ul>
    <c:forEach var="seat" items="${ticket.seats}">
        <li>${seat.seatNumber}</li>
    </c:forEach>
</ul>
<p><strong>Tổng tiền:</strong> ${ticket.totalAmount} VND</p>

<a href="bookingForm">⬅ Quay lại đặt vé</a>
</body>
</html>
