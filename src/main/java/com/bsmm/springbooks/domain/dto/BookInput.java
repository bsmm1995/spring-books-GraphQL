package com.bsmm.springbooks.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BookInput {
    private String title;
    private Integer pages;
    private Integer authorId;
}
