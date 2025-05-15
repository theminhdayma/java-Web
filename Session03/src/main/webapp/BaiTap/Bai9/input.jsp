<%@ page import="com.data.session03.UserManager" %>
<%@ page import="com.data.session03.User" %><%
  UserManager userManager = (UserManager) session.getAttribute("userManager");
  if (userManager == null) {
    userManager = new UserManager();
    session.setAttribute("userManager", userManager);
  }

  String name = request.getParameter("name");
  String email = request.getParameter("email");

  if (name != null && email != null) {
    User newUser = new User(0, name, email);
    userManager.addUser(newUser);
    response.sendRedirect("listUser.jsp");
    return;
  }
%>
<!DOCTYPE html>
<html>
<head><title>Nhap nguoi dung</title></head>
<body>
<form action="input.jsp" method="post">
  Ho ten: <input type="text" name="name" required><br><br>
  Email: <input type="email" name="email" required><br><br>
  <button type="submit">Dang ky</button>
</form>
</body>
</html>
