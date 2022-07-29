package com.bsmm.springbooks.repository;

import com.bsmm.springbooks.domain.entities.AuthorEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AuthorRepository extends JpaRepository<AuthorEntity, Integer> {
    Optional<AuthorEntity> findByFirstName(String firstName);
}
