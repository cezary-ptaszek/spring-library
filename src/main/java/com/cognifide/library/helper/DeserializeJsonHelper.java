package com.cognifide.library.helper;

import com.cognifide.library.model.jsonmodel.Container;
import com.cognifide.library.model.jsonmodel.Item;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.List;

public class DeserializeJsonHelper {

    private DeserializeJsonHelper() {

    }

    public static List<Item> deserializeItem(String pathName) throws FileNotFoundException {

        FileReader reader = new FileReader(pathName);
        Gson gson = new GsonBuilder().serializeNulls().create();
        Container container = gson.fromJson(reader, Container.class);

        return container.getItems();
    }
}
