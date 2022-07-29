package com.bsmm.springbooks.domain.entities;

import com.bsmm.springbooks.domain.Rating;

import javax.persistence.*;

@Entity
public class BookEntity {
    @Id
    @Column(name = "ID", nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String title;
    private Integer pages;
    private Rating rating;

    @ManyToOne
    @JoinColumn(name = "ID_AUTHOR", nullable = false, updatable = false)
    private AuthorEntity author;
}
