package com.cognifide.library.Controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/book")
class BookController {

    @GetMapping
    public ResponseEntity<String> mainView() {
        return ResponseEntity.status(HttpStatus.OK).body("Hello");
    }
}
