<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<html>
<head><title>Quản lý tài chính cá nhân - Thêm giao dịch</title></head>
<body>
<h2>Thêm giao dịch tài chính</h2>

<c:if test="${not empty message}">
    <p style="color:green">${message}</p>
</c:if>

<form action="finance" method="post">
    Tên người dùng:
    <input type="text" name="username" value="${username}" required><br><br>

    Mô tả giao dịch:
    <input type="text" name="description" required><br><br>

    Số tiền:
    <input type="number" name="amount" step="0.01" required><br><br>

    Loại giao dịch:
    <select name="type">
        <option value="thu">Thu</option>
        <option value="chi">Chi</option>
    </select><br><br>

    <button type="submit">Thêm giao dịch</button>
</form>

<br>
<a href="listFinance">Xem danh sách giao dịch</a>
</body>
</html>
