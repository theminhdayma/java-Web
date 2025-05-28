<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<html>
<head><title>Quản lý tài chính cá nhân - Danh sách giao dịch</title></head>
<body>
<h2>Danh sách giao dịch tài chính</h2>

<c:if test="${not empty message}">
    <p style="color:green">${message}</p>
</c:if>

<table border="1" cellpadding="5" cellspacing="0">
    <tr>
        <th>Mô tả</th>
        <th>Số tiền</th>
        <th>Loại</th>
        <th>Thao tác</th>
    </tr>
    <c:forEach var="tran" items="${transactions}" varStatus="status">
        <tr>
            <td>${tran.description}</td>
            <td>${tran.amount}</td>
            <td><c:choose>
                <c:when test="${tran.type == 'thu'}">Thu</c:when>
                <c:otherwise>Chi</c:otherwise>
            </c:choose></td>
            <td><a href="finance/delete/${status.index}">Xóa</a></td>
        </tr>
    </c:forEach>
    <c:if test="${empty transactions}">
        <tr><td colspan="4">Chưa có giao dịch nào.</td></tr>
    </c:if>
</table>

<br>
<a href="finance">Thêm giao dịch mới</a>
</body>
</html>
