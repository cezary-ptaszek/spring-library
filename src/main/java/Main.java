import Helpers.ParsingJsonHelper;
import Models.Item;

import java.io.FileNotFoundException;
import java.util.List;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
     List<Item> items = ParsingJsonHelper.parse("src\\main\\resources\\books.json");
    }
}
