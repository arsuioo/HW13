package org.example;

public class NotFoundException extends RuntimeException {
    public NotFoundException(int id) {
        super("Element with id not found");
    }
}