import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.FileNotFoundException;

@SpringBootApplication
public class LibraryApp {
    public static void main(String[] args) throws FileNotFoundException {
        SpringApplication.run(LibraryApp.class, args);
    }
}
