public class ProductItem {
    private Item item;
    private int quantity;

    public ProductItem(Item item, int quantity) {
        this.item = item;
        this.quantity = quantity;
    }

    public String getName() {
        return item.getName();
    }

    public int getCalories() {
        return item.getCalories();
    }

    public int getQuantity() {
        return quantity;
    }
}
