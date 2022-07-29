package com.bsmm.springbooks.service.impl;

import com.bsmm.springbooks.domain.Author;
import com.bsmm.springbooks.service.AuthorService;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@Service
public class AuthorServiceImpl implements AuthorService {

    private final List<Author> authors = new ArrayList<>();

    @Override
    public List<Author> getAll() {
        return authors;
    }

    @Override
    public Author getById(int id) {
        return authors.stream()
                .filter(author -> author.id() == id)
                .findFirst()
                .orElseThrow(() -> new RuntimeException("Author not found"));
    }

    @Override
    public Author getByName(String name) {
        return authors.stream()
                .filter(author -> author.fullName().equals(name))
                .findFirst()
                .orElseThrow(() -> new RuntimeException("Author not found"));
    }

    @PostConstruct
    private void init() {
        authors.add(new Author(1, "Josh", "Long"));
        authors.add(new Author(2, "Mark", "Heckler"));
        authors.add(new Author(3, "Greg", "Turnquist"));
    }
}
