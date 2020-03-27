package com.cognifide.library.service;

import com.cognifide.library.helper.DeserializeJsonHelper;
import com.cognifide.library.model.Author;
import com.cognifide.library.model.JsonModel.Item;
import org.springframework.stereotype.Service;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

@Service
public class AuthorServiceImpl implements IAuthorService{

    private List<Item> items;

    public AuthorServiceImpl() {
        try {
            items = DeserializeJsonHelper.deserializeItem("src\\main\\resources\\books.json");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
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

    @Override
    public Author getAuthorRatingByName(String name) {
        List<Author> authors = getAuthorsRating();
        for(Author a : authors){
            if(a.getName().equals(name))
                return a;
        }
        return null;
    }

    private void calculateAuthorRating(List<Author> authors, String str, Item item){
        Author author;
        if (getAuthorFromList(authors, str) != null) {
            if(item.getVolumeInfo().getAverageRating() != null) {
                author = getAuthorFromList(authors, str);
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
    }

    private Author getAuthorFromList(List<Author> authors, String author){
        for(Author a : authors){
            if(a.getName().equals(author))
                return a;
        }
        return null;
    }
}
