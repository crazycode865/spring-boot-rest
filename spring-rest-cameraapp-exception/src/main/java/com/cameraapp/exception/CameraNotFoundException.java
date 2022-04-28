package com.cameraapp.exception;

public class CameraNotFoundException extends RuntimeException {
    public CameraNotFoundException() {
    }

    public CameraNotFoundException(String message) {
        super(message);
    }
}
