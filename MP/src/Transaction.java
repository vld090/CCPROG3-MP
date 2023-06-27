public class Transaction {
    private Item item;
    private int payment;

    public Transaction(Item item, int payment) {
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
