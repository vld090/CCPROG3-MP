import java.util.List;

/**
 * Represents an item that can be stored in the vending machine.
 */
public class Item {
    private String name;
    private int calories;

    /**
     * Constructs an item with the specified name and calorie count.
     *
     * @param name     the name of the item
     * @param calories the calorie count of the item
     */
    public Item(String name, int calories) {
        this.name = name;
        this.calories = calories;
    }

    /**
     * Returns the name of the item.
     *
     * @return the name of the item
     */
    public String getName() {
        return name;
    }

    /**
     * Returns the calorie count of the item.
     *
     * @return the calorie count of the item
     */
    public int getCalories() {
        return calories;
    }
}
