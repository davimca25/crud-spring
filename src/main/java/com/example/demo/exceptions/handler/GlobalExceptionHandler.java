package com.example.demo.exceptions.handler;

import com.example.demo.exceptions.custom.UserNotFoundException;
import com.example.demo.exceptions.dto.ApiError;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import java.time.LocalDateTime;
import java.util.List;


@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(UserNotFoundException.class)
    public ResponseEntity<ApiError> userNotFoundHandler(UserNotFoundException exception, HttpServletRequest request) {
        ApiError error = new ApiError(LocalDateTime.now(),404, exception.getMessage(), request.getRequestURI());
        return ResponseEntity.status(404).body(error);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ApiError> MethodArgumentNotValidHandler(MethodArgumentNotValidException exception, HttpServletRequest request) {
        List<String> errors = exception.getBindingResult().getFieldErrors().stream().map(error -> error.getField() + ": " + error.getDefaultMessage()).toList();

        ApiError error = new ApiError(
                LocalDateTime.now(),
                400,
                "Erro de validação",
                request.getRequestURI(),
                errors
        );

        return ResponseEntity.status(400).body(error);
    }
}
