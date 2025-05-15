<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Danh sách ghế</title>
    <style>
        .seat-grid {
            display: flex;
            gap: 15px;
            flex-wrap: wrap;
        }
        .seat-item {
            border: 1px solid #ccc;
            padding: 10px;
            width: 100px;
            text-align: center;
        }
        .booked {
            background-color: #f8d7da;
        }
        .message {
            margin-top: 20px;
            font-weight: bold;
            color: green;
        }
    </style>
</head>
<body>
<h2>Chọn ghế</h2>
<form method="post" action="SeatServlet">
    <div class="seat-grid">
        <c:forEach var="seat" items="${seats}">
            <div class="seat-item ${seat.booked ? 'booked' : ''}">
                <p>${seat.name}</p>
                <p>${seat.price} VNĐ</p>

                <c:if test="${!seat.booked}">
                    <input type="checkbox" name="selectedSeats" value="${seat.id}" />
                </c:if>

                <c:if test="${seat.booked}">
                    <input type="checkbox" disabled />
                    <p style="color:red;">Đã đặt</p>
                </c:if>
            </div>
        </c:forEach>
    </div>
    <br/>
    <button type="submit">Thanh toán</button>
</form>

<c:if test="${not empty message}">
    <div class="message">${message}</div>
</c:if>

</body>
</html>
