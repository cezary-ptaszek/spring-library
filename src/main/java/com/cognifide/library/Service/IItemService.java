package com.cognifide.library.Service;

import com.cognifide.library.Model.Author;
import com.cognifide.library.Model.JsonModel.Item;

import java.util.List;

public interface IItemService {

    Item getItemByIsbn(String isbn);

    List<Item> getItemsByCategory(String category);

    List<Author> getAuthorsRating();

}
