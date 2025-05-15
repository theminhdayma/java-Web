<%@ page contentType="text/html;charset=UTF-8" %>
<%@ page import="java.util.*" %>
<%
    String wordToGuess = (String) session.getAttribute("wordToGuess");
    char[] displayedWord = (char[]) session.getAttribute("displayedWord");
    Integer attemptsLeft = (Integer) session.getAttribute("attemptsLeft");
    String message = (String) request.getAttribute("message");

    if (wordToGuess == null || displayedWord == null || attemptsLeft == null) {
        response.sendRedirect("GuessServlet");
        return;
    }
%>
<!DOCTYPE html>
<html>
<head>
    <title>Game Đoán Chữ</title>
    <style>
        .success { color: blueviolet; font-weight: bold; }
        .fail { color: deeppink; font-weight: bold; }
    </style>
</head>
<body>
<h1>Game Đoán Chữ</h1>
<p><strong>Từ bạn đang phải đoán như sau:</strong>
    <%= new String(displayedWord).replace("", " ").trim() %>
</p>
<p>Bạn còn: <%= attemptsLeft %> lượt đoán</p>

<% if (attemptsLeft > 0 && !wordToGuess.equalsIgnoreCase(new String(displayedWord))) { %>
<form action="GuessServlet" method="post">
    <input type="text" name="guess" placeholder="Nhập từ bạn đoán" required>
    <button type="submit">Đoán</button>
</form>
<% } else { %>
<form action="GuessServlet" method="get">
    <button type="submit">Chơi lại</button>
</form>
<% } %>

<% if (message != null) { %>
<p class="<%= message.contains("đúng") ? "success" : "fail" %>"><%= message %></p>
<% } %>
</body>
</html>
