package com.bsmm.springbooks.service;

import com.bsmm.springbooks.domain.Author;

import java.util.List;

public interface AuthorService {
    List<Author> getAll();

    Author getById(int id);

    Author getByName(String name);
}
