package com.cameraapp.exception;


import com.cameraapp.model.ApiErrors;
import org.springframework.beans.TypeMismatchException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.HttpMediaTypeNotAcceptableException;
import org.springframework.web.HttpMediaTypeNotSupportedException;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MissingPathVariableException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

@ControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {
    public GlobalExceptionHandler() {
        super();
    }

    @Override
    protected ResponseEntity<Object> handleHttpRequestMethodNotSupported(HttpRequestMethodNotSupportedException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
        headers.add("desc","Method not Allowed");
        String error = ex.getMessage();
        List<String> message = Arrays.asList(error,"Method not Supported");
        ApiErrors apiErrors = new ApiErrors(LocalDateTime.now(),status,status.value(),error,message);
        return ResponseEntity.status(status).headers(headers).body(apiErrors);
    }

    @Override
    protected ResponseEntity<Object> handleHttpMediaTypeNotSupported(HttpMediaTypeNotSupportedException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
        headers.add("desc","Media type not supported");
        String error = ex.getMessage();
        List<String> message = Arrays.asList(error,"UnSupported media Type");
        ApiErrors apiErrors = new ApiErrors(LocalDateTime.now(),status,status.value(),error,message);
        return ResponseEntity.status(status).headers(headers).body(apiErrors);
    }

    @Override
    protected ResponseEntity<Object> handleHttpMediaTypeNotAcceptable(HttpMediaTypeNotAcceptableException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {

        headers.add("desc","Media type not acceptable");
        String error = ex.getMessage();
        List<String> message = Arrays.asList(error,"Unacceptable Media Type");
        ApiErrors apiErrors = new ApiErrors(LocalDateTime.now(),status,status.value(),error,message);
        return ResponseEntity.status(status).headers(headers).body(apiErrors);
    }

    @Override
    protected ResponseEntity<Object> handleMissingPathVariable(MissingPathVariableException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
        headers.add("desc","Path variable missing");
        String error = ex.getMessage();
        List<String> message = Arrays.asList(error,"Missing path variable");
        ApiErrors apiErrors = new ApiErrors(LocalDateTime.now(),status,status.value(),error,message);
        return ResponseEntity.status(status).headers(headers).body(apiErrors);
    }

    @Override
    protected ResponseEntity<Object> handleMissingServletRequestParameter(MissingServletRequestParameterException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
        headers.add("desc","Param is missing");
        String error = ex.getMessage();
        List<String> message = Arrays.asList(error,"Missing param");
        ApiErrors apiErrors = new ApiErrors(LocalDateTime.now(),status,status.value(),error,message);
        return ResponseEntity.status(status).headers(headers).body(apiErrors);
    }

    @Override
    protected ResponseEntity<Object> handleTypeMismatch(TypeMismatchException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
        headers.add("desc","Invalid datatype");
        String error = ex.getMessage();
        List<String> message = Arrays.asList(error,"Data Type is not valid");
        ApiErrors apiErrors = new ApiErrors(LocalDateTime.now(),status,status.value(),error,message);
        return ResponseEntity.status(status).headers(headers).body(apiErrors);
    }

    @ExceptionHandler(CameraNotFoundException.class)
    public ResponseEntity<Object> handleCameraNotFound(Exception ex) {
        HttpHeaders headers = new HttpHeaders();
        headers.add("desc","Camera not Found");
        String error = ex.getMessage();
        List<String> message =Arrays.asList(error,"Camera not available");
        ApiErrors apiErrors = new ApiErrors(LocalDateTime.now(),HttpStatus.BAD_REQUEST,HttpStatus.NOT_ACCEPTABLE.value(),error,message);
        return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE).headers(headers).body(apiErrors);
    }
    @ExceptionHandler(Exception.class)
    public ResponseEntity<Object>handleOther(Exception ex){
        HttpHeaders headers = new HttpHeaders();
        headers.add("desc","Other Exception");
        String error = ex.getMessage();
        List<String> message =Arrays.asList(error,"Camera not available");
        ApiErrors apiErrors = new ApiErrors(LocalDateTime.now(),HttpStatus.NOT_ACCEPTABLE,HttpStatus.NOT_ACCEPTABLE.value(),error,message);
        return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE).headers(headers).body(apiErrors);
    }
}
