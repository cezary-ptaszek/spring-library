package com.cognifide.library.controller;

import com.cognifide.library.model.JsonModel.Item;
import com.cognifide.library.service.IItemService;
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
@RequestMapping("/item")
class ItemController {

    @Autowired
    IItemService itemService;

    @GetMapping("/")
    public ResponseEntity<String> hello(){
        return ResponseEntity.status(HttpStatus.OK).body("Hello there!");
    }

    @GetMapping(params = "isbn")
    public ResponseEntity<Item> getItemByIsbn(@RequestParam(value = "isbn") String isbn) {
        Optional<Item> item = Optional.ofNullable(itemService.getItemByIsbn(isbn));
        return item.map(value
                -> ResponseEntity.status(HttpStatus.OK).body(value)).orElseGet(()
                -> ResponseEntity.status(HttpStatus.NOT_FOUND).build());
    }

    @GetMapping(params = "category")
    public ResponseEntity<List<Item>> getItemsByCategory(@RequestParam(value = "category") String category) {
        Optional<List<Item>> items = Optional.ofNullable(itemService.getItemsByCategory(category));
        return items.map(value
                -> ResponseEntity.status(HttpStatus.OK).body(value)).orElseGet(()
                -> ResponseEntity.status(HttpStatus.NOT_FOUND).build());
    }

}
