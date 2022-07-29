package com.bsmm.springbooks.service;

import com.bsmm.springbooks.domain.Book;

import java.util.List;

public interface BookService {
    List<Book> getAll();

    Book getById(Integer id);
}
