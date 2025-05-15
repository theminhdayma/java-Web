
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <%
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String age = request.getParameter("age");

        if (username.equals("admin") && password.equals("123")) {
            if (Integer.parseInt(age) >= 18 ) {
                response.sendRedirect("adult.jsp");
            } else {
                response.sendRedirect("teen.jsp");
            }
        } else {
            out.print("Đăng nhập thất bại !");
        }
    %>
</body>
</html>
