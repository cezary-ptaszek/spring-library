package com.cognifide.library.controller;

import com.cognifide.library.model.Author;
import com.cognifide.library.service.IAuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("/author")
public class AuthorController {

    @Autowired
    IAuthorService authorService;

    @GetMapping("/rating")
    public ResponseEntity<List<Author>> getAuthorsRating() {
        Optional<List<Author>> authors = Optional.ofNullable(authorService.getAuthorsRating());
        return authors.map(value
                -> ResponseEntity.status(HttpStatus.OK).body(value)).orElseGet(()
                -> ResponseEntity.status(HttpStatus.NOT_FOUND).build());
    }

    @GetMapping(value = "/rating", params = "name")
    public ResponseEntity<Author> getAuthorByName(@RequestParam(value="name") String name) {
        Optional<Author> author = Optional.ofNullable(authorService.getAuthorRatingByName(name));
        return author.map(value
                -> ResponseEntity.status(HttpStatus.OK).body(value)).orElseGet(()
                -> ResponseEntity.status(HttpStatus.NOT_FOUND).build());
    }
}