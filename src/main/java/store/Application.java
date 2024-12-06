package store;

import java.io.IOException;
import store.repository.PromotionRepository;
import store.repository.StoreRepository;

public class Application {
    public static void main(String[] args) throws IOException {
        Controller controller = new Controller(new StoreRepository(), new PromotionRepository());
        controller.run();
    }
}
