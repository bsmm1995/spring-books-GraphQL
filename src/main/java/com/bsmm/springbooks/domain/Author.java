package com.bsmm.springbooks.domain;

public record Author(Integer id, String firstName, String lastName) {
    public String fullName() {
        return firstName + " " + lastName;
    }
}
