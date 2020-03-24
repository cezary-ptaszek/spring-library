package Controller;

import Helpers.ParsingJsonHelper;
import Models.FirstParents.Item;
import Models.Isbn;

import java.io.FileNotFoundException;
import java.util.List;

public class ItemController {

    List<Item> items = ParsingJsonHelper.parse("src\\main\\resources\\books.json");

    public ItemController() throws FileNotFoundException {
    }

    public Item getBookByIsbn(String searchedIsbn) {
        for(Item i : items){
            for(Isbn isbnInList : i.getVolumeInfo().getIsbns()){
                if(isbnInList.getIdentifier().equals(searchedIsbn)) {
                    return i;
                }
            }
        }
        return null;
    }
}
