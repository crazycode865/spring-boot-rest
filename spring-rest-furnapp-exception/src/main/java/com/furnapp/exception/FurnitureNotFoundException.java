package com.furnapp.exception;

public class FurnitureNotFoundException extends Exception {
    public FurnitureNotFoundException() {

    }

    public FurnitureNotFoundException(String message) {
        super(message);
    }
}
