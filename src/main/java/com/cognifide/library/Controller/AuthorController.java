package com.cognifide.library.Controller;

import com.cognifide.library.Model.Author;
import com.cognifide.library.Model.JsonModel.Item;
import com.cognifide.library.Service.IItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("/author")
public class AuthorController {

    @Autowired
    IItemService itemService;

    @GetMapping("/rating")
    public ResponseEntity<List<Author>> getAuthorsRating() {
        Optional<List<Author>> authors = Optional.ofNullable(itemService.getAuthorsRating());
        return authors.map(value
                -> ResponseEntity.status(HttpStatus.OK).body(value)).orElseGet(()
                -> ResponseEntity.status(HttpStatus.NOT_FOUND).build());
    }
}