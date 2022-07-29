package com.bsmm.springbooks.domain.dto;

import com.bsmm.springbooks.domain.enums.Rating;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BookAuthor {
    private Integer id;
    private String title;
    private Integer pages;
    private Rating rating;
}
