package Helpers;

import Models.FirstParents.Container;
import Models.FirstParents.Item;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.List;

public class ParsingJsonHelper {

    public static List<Item> parse(String pathName) throws FileNotFoundException {

        FileReader reader = new FileReader(pathName);
        Gson gson = new GsonBuilder().serializeNulls().create();
        Container container = gson.fromJson(reader, Container.class);

        return container.getItems();
    }
}
