package store;

import java.io.IOException;
import store.controller.Controller;

public class Application {
    public static void main(String[] args) throws IOException {
        Controller controller = new Controller();
        controller.run();
    }
}
