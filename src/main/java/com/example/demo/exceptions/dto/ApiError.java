package com.example.demo.exceptions.dto;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;
@Getter
@Setter
public class ApiError {


    private LocalDateTime timestamp;
    private int status;
    private String message;
    private String path;
    private List<String> errors;

    public ApiError(LocalDateTime timestamp, int status, String message, String path) {
        this.timestamp = timestamp;
        this.status = status;
        this.message = message;
        this.path = path;
    }

    public ApiError(LocalDateTime timestamp, int status, String message, String path, List<String> errors) {
        this.timestamp = timestamp;
        this.status = status;
        this.message = message;
        this.path = path;
        this.errors = errors;
    }
}
