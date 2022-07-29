package com.bsmm.springbooks.domain.entities;

import com.bsmm.springbooks.domain.enums.Rating;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity(name = "book")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class BookEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.TABLE, generator = "GEN")
    @Column(name = "ID", nullable = false, unique = true)
    private Integer id;
    private String title;
    private Integer pages;
    private Rating rating;

    @ManyToOne
    @JoinColumn(name = "AUTHOR_ID", nullable = false, updatable = false)
    private AuthorEntity author;
}
