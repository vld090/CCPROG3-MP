import java.util.ArrayList;

public class Product {
    private String name;
    private ArrayList<ProductItem> items;

    public Product(String name) {
        this.name = name;
        this.items = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public ArrayList<ProductItem> getItems() {
        return items;
    }

    public void addItem(ProductItem item) {
        items.add(item);
    }
}
