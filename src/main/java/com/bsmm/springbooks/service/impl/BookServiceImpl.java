package com.bsmm.springbooks.service.impl;

import com.bsmm.springbooks.domain.Book;
import com.bsmm.springbooks.domain.Rating;
import com.bsmm.springbooks.service.AuthorService;
import com.bsmm.springbooks.service.BookService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Service
@RequiredArgsConstructor
public class BookServiceImpl implements BookService {
    private final AuthorService authorService;
    private final List<Book> books = new ArrayList<>();

    @Override
    public List<Book> getAll() {
        return books;
    }

    @Override
    public Book getById(Integer id) {
        return books.stream().filter(book -> Objects.equals(book.id(), id)).findFirst().orElseThrow(() -> new RuntimeException("Book not found"));
    }

    @PostConstruct
    private void init() {
        books.add(new Book(1, "Reactive Spring", 484, Rating.FIVE_STARS, authorService.getByName("Josh Long")));
        books.add(new Book(2, "Spring Boot Up & Running", 328, Rating.FIVE_STARS, authorService.getByName("Mark Heckler")));
        books.add(new Book(3, "Hacking with Spring Boot 2.3", 392, Rating.FIVE_STARS, authorService.getByName("Greg Turnquist")));
    }

}
