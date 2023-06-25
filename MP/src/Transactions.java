public class Transaction {
    private int payment;
    private Item item;

    public Transaction(Item item, int payment){
        this.item = item;
        this.payment = payment;
    }

    public Item getItem() {
        return item;
    }

    public int getPayment() {
        return payment;
    }
}
