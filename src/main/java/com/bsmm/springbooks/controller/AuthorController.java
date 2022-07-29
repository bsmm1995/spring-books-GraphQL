package com.bsmm.springbooks.controller;

import com.bsmm.springbooks.domain.dto.Author;
import com.bsmm.springbooks.domain.dto.AuthorInput;
import com.bsmm.springbooks.service.AuthorService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
@RequiredArgsConstructor
@Slf4j
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

    @MutationMapping(value = "createAuthor")
    public Author create(@Argument AuthorInput data) {
        log.info("data: " + data);
        return this.authorService.create(data);
    }

    @MutationMapping(value = "updateAuthor")
    public Author update(@Argument Integer id, @Argument AuthorInput data) {
        log.info("id: " + id + ", data: " + data);
        return this.authorService.update(id, data);
    }

    @MutationMapping(value = "deleteAuthor")
    public Integer delete(@Argument Integer id) {
        return this.authorService.deleteById(id);
    }
}
