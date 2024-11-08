package store.model;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import store.Utils;

public class Store {
    List<Product> products = new ArrayList<>();
    private static final String SEPARATOR = ",";
    private static final String FILENAME_PRODUCT = "products.md";
    private static final String FILENAME_PROMOTION = "promotions.md";

    public List<Product> getProducts(){
        return products;
    }

    public void initProduct() throws IOException {
        BufferedReader br = Utils.readFile(FILENAME_PRODUCT);
        br.readLine();

        String line;
        while ((line = br.readLine()) != null) {
            String[] separate = Utils.separateStr(line,SEPARATOR);
            products.add(new Product(separate[0],Integer.parseInt(separate[1]),Integer.parseInt(separate[2]),separate[3]));
        }

        br.close();
    }
}
