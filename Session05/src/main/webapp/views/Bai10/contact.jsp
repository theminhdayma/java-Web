<%@ page import="com.data.session05.model.Bai10.Contact" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
    Contact contact = (Contact) request.getAttribute("contact");
    boolean isEdit = contact != null;
%>
<html>
<head><title>Danh sách liên hệ</title></head>
<body>
<h2>Contact List</h2>
<a href="contacts?action=add">Thêm mới liên hệ</a>
<table border="1">
    <tr>
        <th>ID</th><th>First Name</th><th>Last Name</th><th>Email</th><th>Phone</th><th>Actions</th>
    </tr>
    <c:forEach var="c" items="${contacts}">
        <tr>
            <td>${c.id}</td>
            <td>${c.firstName}</td>
            <td>${c.lastName}</td>
            <td>${c.email}</td>
            <td>${c.phone}</td>
            <td>
                <a href="contacts?action=edit&id=${c.id}">Edit</a>
                <form action="contacts" method="post" style="display:inline;">
                    <input type="hidden" name="action" value="delete"/>
                    <input type="hidden" name="id" value="${c.id}"/>
                    <input type="submit" value="Delete"/>
                </form>
            </td>
        </tr>
    </c:forEach>
</table>
</body>
</html>