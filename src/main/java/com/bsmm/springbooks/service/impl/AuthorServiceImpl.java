package com.bsmm.springbooks.service.impl;

import com.bsmm.springbooks.domain.dto.Author;
import com.bsmm.springbooks.domain.dto.AuthorInput;
import com.bsmm.springbooks.domain.entities.AuthorEntity;
import com.bsmm.springbooks.exceptions.NotFoundException;
import com.bsmm.springbooks.repository.AuthorRepository;
import com.bsmm.springbooks.service.AuthorService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AuthorServiceImpl implements AuthorService {
    private final AuthorRepository authorRepository;
    private final ModelMapper mapper;

    @Override
    public List<Author> getAll() {
        return authorRepository.findAll().stream().map(this::toDto).toList();
    }

    @Override
    public Author getById(int id) {
        return toDto(getEntityById(id));
    }

    @Override
    @Transactional
    public Author create(AuthorInput data) {
        return toDto(this.authorRepository.save(mapper.map(data, AuthorEntity.class)));
    }

    @Override
    public Author update(int id, AuthorInput data) {
        AuthorEntity entity = getEntityById(id);
        entity.setFirstName(data.getFirstName());
        entity.setLastName(data.getLastName());
        return toDto(this.authorRepository.save(entity));
    }

    @Override
    public int deleteById(int id) {
        this.authorRepository.deleteById(id);
        return id;
    }

    @Override
    public Author getByName(String name) {
        Optional<AuthorEntity> optional = this.authorRepository.findByFirstName(name);
        if (optional.isEmpty()) {
            throw new NotFoundException("Author not found");
        }
        return toDto(optional.get());
    }

    private AuthorEntity getEntityById(int id) {
        return this.authorRepository.findById(id).orElseThrow(() -> new NotFoundException("Author not found"));
    }

    private Author toDto(AuthorEntity entity) {
        return mapper.map(entity, Author.class);
    }
}
