package com.personal.exception.controller;

import com.personal.exception.exception.ResourceNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping
public class ExceptionController {

    @GetMapping("/custom")
    public ResponseEntity<?> throwResourceNotFoundException() {
        throw new ResourceNotFoundException("Not Found ANy Particular Data");
    }

    @GetMapping("/global")
    public ResponseEntity<?> throwGlobalException() {
        throw new RuntimeException("This is an internal server exception");
    }
}
