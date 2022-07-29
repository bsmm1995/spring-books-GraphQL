package com.bsmm.springbooks.domain.entities;

import javax.persistence.*;
import java.util.List;

@Entity
public class AuthorEntity {
    @Id
    @Column(name = "ID", nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String firstName;
    private String lastName;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "author", fetch = FetchType.LAZY)
    private List<BookEntity> books;
}
