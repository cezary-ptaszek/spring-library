package com.cognifide.library.service;

import com.cognifide.library.model.JsonModel.Item;

import java.util.List;

public interface IItemService {

    Item getItemByIsbn(String isbn);

    List<Item> getItemsByCategory(String category);

}
