package com.data.session06.dao.Bai1;

import com.data.session06.model.Bai1.Book;
import com.data.session06.utils.ConnectionDB;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class BookDaoImp implements BookDao {
    @Override
    public List<Book> findAll() {
        Connection conn = null;
        CallableStatement callSt = null;
        List<Book> listBooks = null;
        try {
            conn = ConnectionDB.openConnection();
            callSt = conn.prepareCall("{call sp_getAllBooks()}");
            ResultSet rs = callSt.executeQuery();
            listBooks = new ArrayList<>();
            while (rs.next()) {
                Book book = new Book();
                book.setBookId(rs.getInt("book_id"));
                book.setTitle(rs.getString("title"));
                book.setAuthor(rs.getString("author"));
                book.setCategory(rs.getString("category"));
                book.setQuantity(rs.getInt("quantity"));
                listBooks.add(book);
            }
        } catch (Exception e) {
            e.fillInStackTrace();
        } finally {
            ConnectionDB.closeConnection(conn, callSt);
        }
        return listBooks;
    }

    @Override
    public boolean save(Book book) {
        Connection conn = null;
        CallableStatement callSt = null;
        boolean result = false;
        try {
            conn = ConnectionDB.openConnection();
            callSt = conn.prepareCall("{call sp_addBook(?,?,?,?)}");
            callSt.setString(1, book.getTitle());
            callSt.setString(2, book.getAuthor());
            callSt.setString(3, book.getCategory());
            callSt.setInt(4, book.getQuantity());
            callSt.executeUpdate();
            result = true;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            ConnectionDB.closeConnection(conn, callSt);
        }
        return result;
    }

    @Override
    public Book findById(int bookId) {
        Connection conn = null;
        CallableStatement callSt = null;
        Book book = null;
        try {
            conn = ConnectionDB.openConnection();
            callSt = conn.prepareCall("{call sp_getBookById(?)}");
            callSt.setInt(1, bookId);
            ResultSet rs = callSt.executeQuery();
            book = new Book();
            if (rs.next()) {
                book.setBookId(rs.getInt("book_id"));
                book.setTitle(rs.getString("title"));
                book.setAuthor(rs.getString("author"));
                book.setCategory(rs.getString("category"));
                book.setQuantity(rs.getInt("quantity"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            ConnectionDB.closeConnection(conn, callSt);
        }
        return book;
    }

    @Override
    public boolean update(Book book) {
        Connection conn = null;
        CallableStatement callSt = null;
        boolean result = false;
        try {
            conn = ConnectionDB.openConnection();
            callSt = conn.prepareCall("{call sp_updateBook(?,?,?,?,?)}");
            callSt.setInt(1, book.getBookId());
            callSt.setString(2, book.getTitle());
            callSt.setString(3, book.getAuthor());
            callSt.setString(4, book.getCategory());
            callSt.setInt(5, book.getQuantity());
            callSt.executeUpdate();
            result = true;
        } catch (Exception e) {
            e.fillInStackTrace();
        } finally {
            ConnectionDB.closeConnection(conn, callSt);
        }
        return result;
    }

    @Override
    public boolean delete(int bookId) {
        Connection conn = null;
        CallableStatement callSt = null;
        boolean result = false;
        try {
            conn = ConnectionDB.openConnection();
            callSt = conn.prepareCall("{call sp_deleteBook(?)}");
            callSt.setInt(1, bookId);
            callSt.executeUpdate();
            result = true;
        } catch (Exception e) {
            e.fillInStackTrace();
        } finally {
            ConnectionDB.closeConnection(conn, callSt);
        }
        return result;
    }
}
