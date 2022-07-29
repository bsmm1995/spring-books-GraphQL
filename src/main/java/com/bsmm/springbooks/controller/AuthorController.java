package com.bsmm.springbooks.controller;

import com.bsmm.springbooks.domain.Author;
import com.bsmm.springbooks.service.AuthorService;
import lombok.RequiredArgsConstructor;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class AuthorController {
    private final AuthorService authorService;

    @QueryMapping
    public List<Author> allAuthors() {
        return authorService.getAll();
    }

    @QueryMapping(value = "findAuthor")
    public Author getById(@Argument Integer id) {
        return authorService.getById(id);
    }

    @QueryMapping(value = "findAuthorByName")
    public Author getByName(@Argument String firstName) {
        return authorService.getByName(firstName);
    }
}
