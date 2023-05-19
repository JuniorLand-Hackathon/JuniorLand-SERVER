package com.hackerton.junior.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public final class GlobalExceptionHandler {
    private final Logger logger = LoggerFactory.getLogger("!!서버 에러!!");

    @ExceptionHandler
    public ResponseEntity<String> handle(final Exception e) {
        logger.error("서버 에러: ", e);

        return ResponseEntity.internalServerError().body("서버 에러 발생 띠용");
    }

    @ExceptionHandler
    public ResponseEntity<String> handle(final IllegalArgumentException e) {
        return ResponseEntity.badRequest().body(e.getMessage());
    }

    @ExceptionHandler
    public ResponseEntity<String> handle(final HttpMessageNotReadableException e) {
        return ResponseEntity.badRequest().body("잘못된 인자로 요청하셨네요!!!");
    }
}
