package com.bsmm.springbooks.controller;

import com.bsmm.springbooks.domain.Book;
import com.bsmm.springbooks.service.BookService;
import lombok.RequiredArgsConstructor;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.graphql.data.method.annotation.SchemaMapping;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class BookController {
    private final BookService bookService;

    @SchemaMapping(typeName = "Query", value = "allBooks")
    public List<Book> getAll() {
        return bookService.getAll();
    }

    @QueryMapping(value = "findBook")
    public Book getById(@Argument Integer id) {
        return bookService.getById(id);
    }
}
