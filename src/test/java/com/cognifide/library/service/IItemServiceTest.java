package com.cognifide.library.service;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class IItemServiceTest {

    private IItemService itemService = new ItemServiceImpl();

    @Test
    void getItemByIsbn() {
        assertEquals("UEdjAgAAQBAJ", itemService.getItemByIsbn("9788324677610").getId());
        assertNull(itemService.getItemByIsbn("45246436442").getId());
    }

    @Test
    void notGetItemByIsbn() {
        assertNotEquals(null, itemService.getItemByIsbn("9788324677610").getId());
    }

    @Test
    void getItemsByCategory() {
        assertEquals("-SYM4PW-YAgC", itemService.getItemsByCategory("Religion").get(0).getId());
        assertTrue(itemService.getItemsByCategory("Moto").isEmpty());
    }
}