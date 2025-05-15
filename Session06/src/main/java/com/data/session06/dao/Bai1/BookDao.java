package com.data.session06.dao.Bai1;

import com.data.session06.model.Bai1.Book;

import java.util.List;

public interface BookDao {
    List<Book> findAll();

    boolean save(Book book);

    Book findById(int bookId);

    boolean update(Book book);

    boolean delete(int bookId);
}
