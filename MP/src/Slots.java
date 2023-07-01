/**
 * Represents a slot in a vending machine that holds an item.
 */
public class Slots {
    private Item item;
    private int price;
    private int qty;

    /**
     * Constructs a slot with the specified item, price, and quantity.
     *
     * @param item  the item in the slot
     * @param price the price of the item
     * @param qty   the quantity of the item in the slot
     */
    public Slots(Item item, int price, int qty){
        this.item = item;
        this.price = price;
        this.qty = qty;
    }

    /**
     * Checks if the slot has any available quantity of the item.
     *
     * @return true if the slot has available quantity, false otherwise
     */
    public boolean getAvailability(){
        return qty > 0;
    }

    /**
     * Returns the price of the item in the slot.
     *
     * @return the price of the item
     */
    public int getPrice() {
        return price;
    }

    /**
     * Returns the quantity of the item in the slot.
     *
     * @return the quantity of the item
     */
    public int getQty() {
        return qty;
    }

    /**
     * Returns the item in the slot.
     *
     * @return the item in the slot
     */
    public Item getItem(){
        return item;
    }


    /**
     * Sets the price of the item in the slot.
     *
     * @param price the price to set
     */
    public void setPrice(int price) {
        this.price = price;
    }

    /**
     * Sets the quantity of the item in the slot.
     *
     * @param qty the quantity to set
     */
    public void setQty(int qty) {
        this.qty = qty;
    }
}