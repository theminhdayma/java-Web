<%@ page import="com.data.session03.UserManager" %><%
    int userId = Integer.parseInt(request.getParameter("id"));
    UserManager userManager = (UserManager) session.getAttribute("userManager");

    if (userManager != null) {
        userManager.removeUser(userId);
    }

    response.sendRedirect("listUser.jsp");
%>
