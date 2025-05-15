package com.data.session03;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

@WebServlet (name = "BookServlet", value = "/BookServlet")
public class BookServlet extends HttpServlet {
    private final List<Book> bookList = new ArrayList<>();

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String title = request.getParameter("title");
        String author = request.getParameter("author");
        int year = Integer.parseInt(request.getParameter("year"));

        bookList.add(new Book(title, author, year));

        request.setAttribute("books", bookList);
        request.getRequestDispatcher("BaiTap/Bai8/home.jsp").forward(request, response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String search = request.getParameter("search");

        List<Book> filteredBooks = bookList;
        if (search != null && !search.trim().isEmpty()) {
            filteredBooks = bookList.stream()
                    .filter(b -> b.getTitle().toLowerCase().contains(search.toLowerCase()))
                    .collect(Collectors.toList());
        }

        request.setAttribute("books", filteredBooks);
        request.getRequestDispatcher("BaiTap/Bai8/home.jsp").forward(request, response);
    }
}
