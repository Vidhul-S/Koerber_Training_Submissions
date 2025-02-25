package com.book.bookApp.controller;

import com.book.bookApp.dto.ErrorResponeDto;
import com.book.bookApp.exceptions.BookNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;
import java.util.stream.Collectors;

@RestControllerAdvice
public class BookAppExceptionHandlerController {
    @ExceptionHandler(BookNotFoundException.class)
    public ResponseEntity<ErrorResponeDto> handleBankAccountNotFoundException(BookNotFoundException ex) {
        System.out.println("^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^");
        ErrorResponeDto errorResponeDto=ErrorResponeDto
                .builder()
                .timeStamp(LocalDateTime.now())
                .errorCode(HttpStatus.NOT_FOUND.toString())
                .errorMessge(ex.getMessage())
                .toContact("nitish@gmail.com")
                .build();
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorResponeDto);
    }

    //MethodArgumentNotValidException
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ErrorResponeDto> handle400(MethodArgumentNotValidException ex) {

        String errorMessage=ex.getBindingResult()
                .getAllErrors()
                .stream()
                .map(error->error.getDefaultMessage())
                .collect(Collectors.joining(", "));

        ErrorResponeDto errorResponeDto=ErrorResponeDto
                .builder()
                .timeStamp(LocalDateTime.now())
                .errorCode(HttpStatus.BAD_REQUEST.toString())
                .errorMessge(errorMessage)
                .toContact("nitish@gmail.com")
                .build();
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorResponeDto);
    }

}
