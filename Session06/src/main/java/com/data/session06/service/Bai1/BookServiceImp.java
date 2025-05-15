package com.data.session06.service.Bai1;

import com.data.session06.dao.Bai1.BookDao;
import com.data.session06.dao.Bai1.BookDaoImp;
import com.data.session06.model.Bai1.Book;

import java.util.List;

public class BookServiceImp implements BookService {
    private final BookDao bookDao;

    public BookServiceImp () {
        bookDao = new BookDaoImp();
    }
    @Override
    public List<Book> findAll() {
        return bookDao.findAll();
    }

    @Override
    public boolean save(Book book) {
        return bookDao.save(book);
    }

    @Override
    public Book findById(int bookId) {
        return bookDao.findById(bookId);
    }

    @Override
    public boolean update(Book book) {
        return bookDao.update(book);
    }

    @Override
    public boolean delete(int bookId) {
        return bookDao.delete(bookId);
    }
}
