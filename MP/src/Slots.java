public class Slots {
    private Item item;
    private int price;
    private int qty;


    public Slots(Item item, int price, int qty){
        this.item = item;
        this.price = price;
        this.qty = qty;
    }

    public boolean getAvailability(){
        if(qty > 0)
            return true;
        else
            return false;
    }

    public int getPrice() {
        return price;
    }

    public int getQty() {
        return qty;
    }

    public Item getItem(){
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public void setQty(int qty) {
        this.qty = qty;
    }
}
