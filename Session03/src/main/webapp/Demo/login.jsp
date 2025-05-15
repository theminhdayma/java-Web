<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title></title>
</head>
<body>
    <h1>Đăng nhập</h1>
    <form action="result.jsp" method="post">
        <label for=username>Tên đăng nhập:</label><br>
        <input type="text" id="username" name="username" required><br><br>

        <label for="password">Mật khẩu:</label><br>
        <input type="text" id="password" name="password" required><br><br>

        <label for="age">Tuổi:</label><br>
        <input type="number" id="age" name="age" required><br><br>

        <button type="submit">Đăng nhập</button>
    </form>
</body>
</html>
