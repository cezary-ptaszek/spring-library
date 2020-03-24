package Server;

import Controller.ItemController;
import Models.FirstParents.Item;
import com.google.gson.Gson;
import io.vertx.core.Vertx;
import io.vertx.core.http.HttpServer;
import io.vertx.core.http.HttpServerResponse;
import io.vertx.core.json.Json;
import io.vertx.ext.web.Router;
import jdk.jshell.ImportSnippet;

import java.io.FileNotFoundException;
import java.util.Optional;

public class Server {

    public Server(){
        run();
    }

    public void run() {
        Vertx vertx = Vertx.vertx();
        HttpServer httpServer = vertx.createHttpServer();

        Router router = Router.router(vertx);

        router
                .get("/book/:ISBN")
                .handler(routingContext -> {
                    String ISBN = routingContext.request().getParam("ISBN");
                    Optional<Item> item = null;
                    try {
                        item = Optional.ofNullable(new ItemController().getBookByIsbn(ISBN));
                    } catch (FileNotFoundException e) {
                        e.printStackTrace();
                    }
                    
                    HttpServerResponse response = routingContext.response();
                    response.putHeader("content-type", "application/json; charset=utf-8");
                    response.end(new Gson().toJson(item));
                });

        httpServer
                .requestHandler(router)
                .listen(8080);
        System.out.println("Server started at port: " + httpServer.actualPort());
    }
}
