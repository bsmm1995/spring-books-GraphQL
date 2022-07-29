package com.bsmm.springbooks.controller;

import com.bsmm.springbooks.domain.dto.Book;
import com.bsmm.springbooks.domain.dto.BookInput;
import com.bsmm.springbooks.service.BookService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.graphql.data.method.annotation.SchemaMapping;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
@RequiredArgsConstructor
@Slf4j
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

    @MutationMapping(value = "createBook")
    public Book create(@Argument BookInput data) {
        log.info("data: " + data);
        return this.bookService.create(data);
    }

    @MutationMapping(value = "updateBook")
    public Book update(@Argument Integer id, @Argument BookInput data) {
        log.info("id: " + id + ", data: " + data);
        return this.bookService.update(id, data);
    }

    @MutationMapping(value = "deleteBook")
    public Integer delete(@Argument Integer id) {
        return this.bookService.deleteById(id);
    }
}
