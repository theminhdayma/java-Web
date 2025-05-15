<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.*" %>
<%@ page import="com.data.session04.Bai6.Student" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%
    List<Student> students = new ArrayList<>();
    students.add(new Student(1, "Nguyễn Văn A", 20, 8.2));
    students.add(new Student(2, "Trần Thị B", 19, 6.5));
    students.add(new Student(3, "Lê Văn C", 21, 7.8));
    students.add(new Student(4, "Phạm Thị D", 22, 5.9));

    request.setAttribute("students", students);
%>

<html>
<head>
    <title>Danh Sách Sinh Viên</title>
    <style>
        table { border-collapse: collapse; width: 60%; margin-top: 20px; }
        th, td { border: 1px solid black; padding: 8px; text-align: center; }
        th { background-color: #f2f2f2; }
    </style>
</head>
<body>
<h2>Danh Sách Sinh Viên</h2>

<table>
    <tr>
        <th>ID</th>
        <th>Họ tên</th>
        <th>Tuổi</th>
        <th>Điểm TB</th>
    </tr>
    <c:set var="count" value="0" />
    <c:forEach var="sv" items="${students}">
        <tr>
            <td>${sv.id}</td>
            <td>${sv.name}</td>
            <td>${sv.age}</td>
            <td>${sv.gpa}</td>
        </tr>
        <c:if test="${sv.gpa > 7.0}">
            <c:set var="count" value="${count + 1}" />
        </c:if>
    </c:forEach>
</table>

<h3>Số sinh viên có điểm TB > 7.0: <span style="color:green">${count}</span></h3>
</body>
</html>
