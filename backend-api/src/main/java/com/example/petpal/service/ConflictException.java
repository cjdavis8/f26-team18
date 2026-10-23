package com.example.petpal.service;

public class ConflictException extends RuntimeException {
    public ConflictException(String message) {
        super(message);
    }
}