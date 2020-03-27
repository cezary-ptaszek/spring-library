package com.cognifide.library.service;

import com.cognifide.library.model.Author;

import java.util.List;

public interface IAuthorService {

    List<Author> getAuthorsRating();

    Author getAuthorRatingByName(String name);
}
