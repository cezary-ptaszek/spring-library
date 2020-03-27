package com.cognifide.library.service;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class IAuthorServiceTest {

    IAuthorService authorService = new AuthorServiceImpl();

    @Test
    void getAuthorsRating() {
        assertEquals(5.0, authorService.getAuthorsRating().get(0).getRating());
        assertFalse(authorService.getAuthorsRating().isEmpty());
    }

    @Test
    void getAuthorRatingByName() {
        assertEquals("BUYYA", authorService.getAuthorRatingByName("BUYYA").getName());
        assertNotEquals("Jain Pravin", authorService.getAuthorRatingByName("BUYYA").getName());
    }
}