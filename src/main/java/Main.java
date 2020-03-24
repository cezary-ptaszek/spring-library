import Helpers.ParsingJsonHelper;
import Models.FirstParents.Item;
import io.vertx.core.Vertx;
import io.vertx.core.http.HttpServer;
import io.vertx.core.http.HttpServerResponse;
import io.vertx.ext.web.Router;

import java.io.FileNotFoundException;
import java.util.List;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
     List<Item> items = ParsingJsonHelper.parse("src\\main\\resources\\books.json");

        Vertx vertx = Vertx.vertx();
        HttpServer httpServer = vertx.createHttpServer();

        Router router = Router.router(vertx);

        router
                .get("/book/details")
                .handler(routingContext -> {
                    HttpServerResponse response = routingContext.response();
                    response.putHeader("content-type", "text/plain");
                    response.end("Hello");
        });

        httpServer
                .requestHandler(router)
                .listen(8080);
        System.out.println("Server started at: " + httpServer.actualPort());
    }
}
