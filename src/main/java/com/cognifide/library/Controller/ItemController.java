package com.cognifide.library.Controller;

import com.cognifide.library.Model.JsonModel.Item;
import com.cognifide.library.Service.IItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/book")
class ItemController {

    @Autowired
    IItemService itemService;

    @GetMapping("/")
    public ResponseEntity<String> hello(){
        return ResponseEntity.status(HttpStatus.OK).body("Hello there!");
    }

    @GetMapping(params = "isbn")
    @ResponseBody
    public ResponseEntity<Item> getItemByIsbn(@RequestParam(required=false) String isbn) {
        Optional<Item> item = Optional.ofNullable(itemService.getItemByIsbn(isbn));
        return item.map(value
                -> ResponseEntity.status(HttpStatus.OK).body(value)).orElseGet(()
                -> ResponseEntity.status(HttpStatus.NOT_FOUND).build());
    }

    @GetMapping(params = "category")
    public ResponseEntity<List<Item>> getItemsByCategory(@RequestParam(value="category") String category) {
        Optional<List<Item>> items = Optional.ofNullable(itemService.getItemsByCategory(category));
        return items.map(value
                -> ResponseEntity.status(HttpStatus.OK).body(value)).orElseGet(()
                -> ResponseEntity.status(HttpStatus.NOT_FOUND).build());
    }

}
