/**
 * Represents a transaction in a vending machine.
 */
public class Transaction {
    private Item item;
    private int payment;

    /**
     * Constructs a transaction with the specified item and payment.
     *
     * @param item    the item in the transaction
     * @param payment the payment made in the transaction
     */
    public Transaction(Item item, int payment){
        this.item = item;
        this.payment = payment;
    }

    /**
     * Returns the item in the transaction.
     *
     * @return the item in the transaction
     */
    public Item getItem() {
        return item;
    }

    /**
     * Returns the payment made in the transaction.
     *
     * @return the payment made in the transaction
     */
    public int getPayment() {
        return payment;
    }
}