<%@ page import="com.data.session01.Student" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Danh sách sinh viên</title>
</head>
<body>
<h2>Danh sách sinh viên đăng ký vé xe</h2>

<table border="1">
    <thead>
    <tr>
        <th>Họ và tên</th>
        <th>Lớp</th>
        <th>Loại xe</th>
        <th>Biển số xe</th>
    </tr>
    </thead>
    <tbody>
    <%
        List<Student> students = (List<Student>) request.getAttribute("students");

        for (Student student : students) {
    %>
    <tr>
        <td><%= student.getFullName() %></td>
        <td><%= student.getStudentClass() %></td>
        <td><%= student.getVehicleType() %></td>
        <td><%= student.getLicensePlate() %></td>
    </tr>
    <%
        }
    %>
    </tbody>
</table>

</body>
</html>
