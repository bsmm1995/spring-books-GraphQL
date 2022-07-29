package com.bsmm.springbooks.domain;

public record Book(Integer id, String title, Integer pages, Rating rating, Author author) {
}
