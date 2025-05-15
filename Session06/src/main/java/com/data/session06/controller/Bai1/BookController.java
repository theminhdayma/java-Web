package com.data.session06.controller.Bai1;

import com.data.session06.model.Bai1.Book;
import com.data.session06.service.Bai1.BookService;
import com.data.session06.service.Bai1.BookServiceImp;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "BookController", value = "/books")
public class BookController extends HttpServlet {
    private BookService bookService;

    @Override
    public void init() throws ServletException {
        bookService = new BookServiceImp();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        String action = req.getParameter("action");
        if (action == null) action = "list";

        switch (action) {
            case "create":
                req.getRequestDispatcher("views/Bai1/formAdd.jsp").forward(req, resp);
                break;
            case "edit":
                int editId = Integer.parseInt(req.getParameter("id"));
                Book editBook = bookService.findById(editId);
                req.setAttribute("book", editBook);
                req.getRequestDispatcher("views/Bai1/formEdit.jsp").forward(req, resp);
                break;
            case "delete":
                int deleteId = Integer.parseInt(req.getParameter("id"));
                bookService.delete(deleteId);
                resp.sendRedirect("books");
                break;
            default:
                List<Book> list = bookService.findAll();
                req.setAttribute("listBooks", list);
                req.getRequestDispatcher("views/Bai1/listBook.jsp").forward(req, resp);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        String action = req.getParameter("action");

        if ("create".equals(action)) {
            Book newBook = new Book();
            newBook.setTitle(req.getParameter("title"));
            newBook.setAuthor(req.getParameter("author"));
            newBook.setCategory(req.getParameter("category"));
            newBook.setQuantity(Integer.parseInt(req.getParameter("quantity")));
            bookService.save(newBook);
            resp.sendRedirect("books");
        } else if ("edit".equals(action)) {
            Book updateBook = new Book();
            updateBook.setBookId(Integer.parseInt(req.getParameter("id")));
            updateBook.setTitle(req.getParameter("title"));
            updateBook.setAuthor(req.getParameter("author"));
            updateBook.setCategory(req.getParameter("category"));
            updateBook.setQuantity(Integer.parseInt(req.getParameter("quantity")));
            bookService.update(updateBook);
            resp.sendRedirect("books");
        }
    }
}
