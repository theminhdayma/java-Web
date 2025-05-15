<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>Quiz Game</title>
</head>
<body>
<h2>Đoán hình ảnh</h2>

<div>
    <img src="${question.imageUrl}" alt="Câu hỏi" width="300" height="200"/>
</div>

<c:if test="${not empty message}">
    <p style="color:blue;">${message}</p>
</c:if>

<c:if test="${not outOfAttempts and not correct}">
    <form method="post" action="guess">
        <label>Nhập câu trả lời:</label>
        <input type="text" name="userAnswer" required/>
        <button type="submit">Đoán</button>
    </form>
</c:if>

<c:if test="${correct or outOfAttempts}">
    <form method="get" action="quiz">
        <button type="submit">Chơi lại</button>
    </form>
</c:if>
</body>
</html>
