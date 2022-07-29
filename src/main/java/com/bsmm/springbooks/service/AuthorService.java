package com.bsmm.springbooks.service;

import com.bsmm.springbooks.domain.dto.Author;
import com.bsmm.springbooks.domain.dto.AuthorInput;

import java.util.List;

public interface AuthorService {
    List<Author> getAll();

    Author getById(int id);

    Author getByName(String name);

    Author create(AuthorInput data);

    Author update(int id, AuthorInput data);

    int deleteById(int id);
}
