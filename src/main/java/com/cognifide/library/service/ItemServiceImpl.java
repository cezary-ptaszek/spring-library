package com.cognifide.library.service;

import com.cognifide.library.helper.DeserializeJsonHelper;
import com.cognifide.library.model.JsonModel.Isbn;
import com.cognifide.library.model.JsonModel.Item;
import org.springframework.stereotype.Service;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

@Service
public class ItemServiceImpl implements IItemService{

    private List<Item> items;

    public ItemServiceImpl() {
        try {
            items = DeserializeJsonHelper.deserializeItem("src\\main\\resources\\books.json");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Item getItemByIsbn(String givenIsbn) {
        for(Item i : items) {
            for (Isbn isbn : i.getVolumeInfo().getIsbns()) {
                if (isbn.getIdentifier().equals(givenIsbn))
                    return i;
            }
        }
        return null;
    }

    @Override
    public List<Item> getItemsByCategory(String category) {
        List<Item> itemsByCategory = new ArrayList<>();
        for(Item i : items){
            if(i.getVolumeInfo().getCategories()!=null) {
                for (String s : i.getVolumeInfo().getCategories()) {
                    if (s.equals(category))
                        itemsByCategory.add(i);
                }
            }
        }
        return itemsByCategory;
    }
}
