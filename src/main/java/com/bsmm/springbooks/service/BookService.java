package com.bsmm.springbooks.service;

import com.bsmm.springbooks.domain.dto.Book;
import com.bsmm.springbooks.domain.dto.BookInput;

import java.util.List;

public interface BookService {
    List<Book> getAll();

    Book getById(int id);

    Book create(BookInput data);

    Book update(int id, BookInput data);

    int deleteById(int id);
}
