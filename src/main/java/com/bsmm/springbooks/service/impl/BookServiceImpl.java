package com.bsmm.springbooks.service.impl;

import com.bsmm.springbooks.domain.dto.Author;
import com.bsmm.springbooks.domain.dto.Book;
import com.bsmm.springbooks.domain.dto.BookInput;
import com.bsmm.springbooks.domain.entities.AuthorEntity;
import com.bsmm.springbooks.domain.entities.BookEntity;
import com.bsmm.springbooks.exceptions.NotFoundException;
import com.bsmm.springbooks.repository.BookRepository;
import com.bsmm.springbooks.service.AuthorService;
import com.bsmm.springbooks.service.BookService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BookServiceImpl implements BookService {

    private final BookRepository bookRepository;
    private final AuthorService authorService;
    private final ModelMapper mapper;

    @Override
    public List<Book> getAll() {
        return bookRepository.findAll().stream().map(this::toDto).toList();
    }

    @Override
    public Book getById(int id) {
        return toDto(getEntityById(id));
    }

    @Override
    public Book create(BookInput data) {
        return toDto(bookRepository.save(mapper.map(data, BookEntity.class)));
    }

    @Override
    public Book update(int id, BookInput data) {
        BookEntity entity = getEntityById(id);
        entity.setPages(data.getPages());
        entity.setTitle(data.getTitle());
        setAuthor(data.getAuthorId(), entity);
        return toDto(this.bookRepository.save(entity));
    }

    @Override
    public int deleteById(int id) {
        this.bookRepository.deleteById(id);
        return id;
    }

    private BookEntity getEntityById(int id) {
        return this.bookRepository.findById(id).orElseThrow(() -> new NotFoundException("Author not found"));
    }

    private Book toDto(BookEntity entity) {
        return mapper.map(entity, Book.class);
    }

    private void setAuthor(int id, BookEntity entity) {
        Author author = authorService.getById(id);
        entity.setAuthor(mapper.map(author, AuthorEntity.class));
    }
}
