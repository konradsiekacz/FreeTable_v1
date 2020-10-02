package com.mmkpdevelopers.freetable.exceptions;

public class UserNotFoundException extends RuntimeException {
    public UserNotFoundException(String id) {
        super(String.format("Client doesn't exist for given id: %s", id));
    }
}
