package com.bsmm.springbooks.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Author {
    private Integer id;
    private String firstName;
    private String lastName;
    List<BookAuthor> books;
}
