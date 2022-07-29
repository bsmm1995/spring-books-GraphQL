package com.bsmm.springbooks.repository;

import com.bsmm.springbooks.domain.entities.BookEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<BookEntity, Integer> {
}
