package store;

import java.io.IOException;
import store.controllers.Controller;
import store.models.Store;

public class Application {
    public static void main(String[] args) throws IOException {
        Store store = new Store();
        Controller controller = new Controller(store);
        controller.run();
    }
}
