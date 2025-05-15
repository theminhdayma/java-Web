<%@ page import="com.data.session05.model.Bai10.Contact" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
    Contact contact = (Contact) request.getAttribute("contact");
    boolean isEdit = contact != null;
%>
<html>
<head><title><%= isEdit ? "Edit" : "Add" %> Contact</title></head>
<body>
<h2><%= isEdit ? "Edit" : "Add" %> Contact</h2>
<form action="contacts" method="post">
    <input type="hidden" name="action" value="<%= isEdit ? "update" : "create" %>"/>
    <c:if test="${contact != null}">
        <input type="hidden" name="id" value="${contact.id}"/>
    </c:if>
    First Name: <input type="text" name="firstName" value="${contact != null ? contact.firstName : ''}"/><br/>
    Last Name: <input type="text" name="lastName" value="${contact != null ? contact.lastName : ''}"/><br/>
    Email: <input type="text" name="email" value="${contact != null ? contact.email : ''}"/><br/>
    Phone: <input type="text" name="phone" value="${contact != null ? contact.phone : ''}"/><br/>
    <input type="submit" value="<%= isEdit ? "Update" : "Create" %>"/>
</form>
</body>
</html>
