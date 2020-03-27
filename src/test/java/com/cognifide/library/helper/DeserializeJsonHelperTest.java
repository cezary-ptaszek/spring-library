package com.cognifide.library.helper;

import com.cognifide.library.model.jsonmodel.Item;
import org.junit.jupiter.api.Test;

import java.io.FileNotFoundException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class DeserializeJsonHelperTest {

    @Test
    void deserializeItem() throws FileNotFoundException {
        List<Item> items = DeserializeJsonHelper.deserializeItem("src\\main\\resources\\books.json");
        assertEquals("dXytGSDckJk", items.get(1).getEtag());
    }

    @Test
    void deserializeItemExpectedException(){
        assertThrows(FileNotFoundException.class, () -> {
            List<Item> items = DeserializeJsonHelper.deserializeItem("books.json");
        });
    }
}