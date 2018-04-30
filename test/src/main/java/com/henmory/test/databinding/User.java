package com.henmory.test.databinding;

/**
 * author: henmory
 * time:  3/19/18
 * function:
 * description:
 */

public class User {
    private final String firstName;
    private final String lastName;
    public User(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }
    public String getFirstName() {
        return this.firstName;
    }
    public String getLastName() {
        return this.lastName;
    }
}
