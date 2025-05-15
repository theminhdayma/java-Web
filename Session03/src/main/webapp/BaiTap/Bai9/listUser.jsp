<%@ page import="com.data.session03.UserManager" %>
<%@ page import="com.data.session03.User" %>
<%@ page import="java.util.List" %><%
    UserManager userManager = (UserManager) session.getAttribute("userManager");
    if (userManager == null) {
        userManager = new UserManager();
        session.setAttribute("userManager", userManager);
    }

    List<User> users = userManager.getUsers();
%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Danh sach nguoi dung</title>
    <script>
        function confirmDelete(id) {
            if (confirm('Ban co chac muon xoa nguoi dung nay?')) {
                window.location.href = 'deleteUser.jsp?id=' + id;
            }
        }
    </script>
</head>
<body>
<h2>Danh sach nguoi dung</h2>
<table border="1">
    <tr>
        <th>ID</th>
        <th>Ho ten</th>
        <th>Email</th>
        <th>Hanh dong</th>
    </tr>
    <%
        for (User user : users) {
    %>
    <tr>
        <td><%= user.getId() %></td>
        <td><%= user.getName() %></td>
        <td><%= user.getEmail() %></td>
        <td><button onclick="confirmDelete(<%= user.getId() %>)">Xoa</button></td>
    </tr>
    <% } %>
</table>
<a href="input.jsp">Them nguoi dung</a>
</body>
</html>
