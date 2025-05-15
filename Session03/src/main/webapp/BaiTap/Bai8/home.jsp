<%@ page contentType="text/html;charset=UTF-8" %>
<%@ page import="java.util.List" %>
<%@ page import="com.data.session03.Book" %>
<!DOCTYPE html>
<html>
<head>
    <title>Book Manager</title>
</head>
<body>
<h2>Add New Book</h2>
<form method="post" action="BookServlet">
    Title: <input type="text" name="title" required /><br/><br/>
    Author: <input type="text" name="author" required /><br/><br/>
    Year: <input type="number" name="year" required /><br/><br/>
    <input type="submit" value="Add Book" />
</form>

<h2>Search Books</h2>
<form method="get" action="BookServlet">
    Search by title: <input type="text" name="search" />
    <input type="submit" value="Search" />
</form>

<h2>Book List</h2>
<table border="1" cellpadding="8">
    <tr>
        <th>Title</th>
        <th>Author</th>
        <th>Year</th>
    </tr>
    <%
        List<Book> books = (List<Book>) request.getAttribute("books");
        if (books != null) {
            for (Book book : books) {
    %>
    <tr>
        <td><%= book.getTitle() %></td>
        <td><%= book.getAuthor() %></td>
        <td><%= book.getYear() %></td>
    </tr>
    <%
            }
        }
    %>
</table>
</body>
</html>
