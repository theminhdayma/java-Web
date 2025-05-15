<%@ page contentType="text/html;charset=UTF-8" %>
<%@ page import="java.util.List" %>
<%@ page import="com.data.session05.model.Bai2_3_4_5_6_7.Student" %>
<%
    List<Student> students = (List<Student>) request.getAttribute("students");
    int currentPage = (Integer) request.getAttribute("currentPage");
    int totalPages = (Integer) request.getAttribute("totalPages");
%>
<html>
<head>
    <title>Danh sách sinh viên</title>
</head>
<body>
<h2>Danh sách sinh viên</h2>
<table border="1" cellpadding="10">
    <tr>
        <th>ID</th><th>Họ tên</th><th>Tuổi</th><th>Địa chỉ</th><th>Hành động</th>
    </tr>
    <%
        for (Student s : students) {
    %>
    <tr>
        <td><%= s.getId() %></td>
        <td><%= s.getName() %></td>
        <td><%= s.getAge() %></td>
        <td><%= s.getAddress() %></td>
        <td>
            <a href="studentController?action=edit&id=<%= s.getId() %>">Sửa</a> |
            <a href="studentController?action=delete&id=<%= s.getId() %>" onclick="return confirm('Bạn có chắc muốn xoá?')">Xoá</a>
        </td>
    </tr>
    <%
        }
    %>
</table>

<div>
    <%
        for (int i = 1; i <= totalPages; i++) {
            if (i == currentPage) {
                out.print("<strong>" + i + "</strong> ");
            } else {
                out.print("<a href='studentController?page=" + i + "'>" + i + "</a> ");
            }
        }
    %>
</div>

<br>
<a href="views/Bai2+3+4+5+6+7/form.jsp">Thêm sinh viên mới</a>
</body>
</html>
