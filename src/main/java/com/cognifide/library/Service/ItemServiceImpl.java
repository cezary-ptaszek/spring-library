package com.cognifide.library.Service;

import com.cognifide.library.Helper.DeserializeJsonHelper;
import com.cognifide.library.Model.Author;
import com.cognifide.library.Model.JsonModel.Isbn;
import com.cognifide.library.Model.JsonModel.Item;
import org.springframework.stereotype.Service;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Comparator;
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

    @Override
    public List<Author> getAuthorsRating() {
        List<Author> authors = new ArrayList<>();
        for(Item i : items){
            if(i.getVolumeInfo().getAuthors() != null) {
                for (String s : i.getVolumeInfo().getAuthors()) {
                    calculateAuthorRating(authors, s, i);
                }
            }
        }
       authors.sort(Comparator.comparing(Author::getRating).reversed());
        return authors;
    }

    private List<Author> calculateAuthorRating(List<Author> authors, String str, Item item){
        Author author;
        if (getAuthorFromList(authors, str) != null) {
            author = getAuthorFromList(authors, str);
            if(item.getVolumeInfo().getAverageRating() != null) {
                assert author != null;
                author.setCurrCounter(author.getCurrCounter() + 1);
                author.setRating((author.getRating() + item.getVolumeInfo().getAverageRating())/author.getCurrCounter());
                author.setAllCounter(author.getAllCounter() + item.getVolumeInfo().getRatingsCount());
            }
        } else {
            if(item.getVolumeInfo().getAverageRating() != null) {
                author = new Author(str,
                        item.getVolumeInfo().getAverageRating(),
                        item.getVolumeInfo().getRatingsCount(),
                        0);
                authors.add(author);
            }
        }
        return authors;
    }

    private Author getAuthorFromList(List<Author> authors, String author){
        for(Author a : authors){
            if(a.getName().equals(author))
                return a;
        }
        return null;
    }
}
