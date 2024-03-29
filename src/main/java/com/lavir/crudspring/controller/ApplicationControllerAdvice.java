package com.lavir.crudspring.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.lavir.crudspring.exception.RecordNotFoundException;

@RestControllerAdvice
public class ApplicationControllerAdvice {

  @ExceptionHandler(RecordNotFoundException.class)
  @ResponseStatus(HttpStatus.NOT_FOUND)
  public String handleNotFoundeException(RecordNotFoundException ex) {
    return ex.getMessage();
  }
}
