import java.util.ArrayList;

/**
 * Represents a vending machine that holds slots of items and handles transactions.
 */
public class VendingMachine {
    private Slots[] slots;
    private ArrayList<Transaction> transactionLog;
    private PaymentProcess paymentProcess;

      /**
     * Constructs a VendingMachine object with the specified slots and payment process.
     *
     * @param slots          the array of slots containing items
     * @param paymentProcess the payment process for handling transactions
     */
    public VendingMachine(Slots[] slots, PaymentProcess paymentProcess) {
        this.slots = slots;
        this.paymentProcess = paymentProcess;
        this.transactionLog = new ArrayList<>();
    }

    /**
     * Displays the available items in the vending machine.
     */
    public void displayItems() {
        System.out.println("Available items:");
        for (int i = 0; i < slots.length; i++) {
            Slots slot = slots[i];
            Item item = slot.getItem();
            if (item != null) {
                System.out.print("Slot " + i + ": ");
                System.out.print(item.getName() + " - ");
                System.out.print("Price: " + slot.getPrice() + " - ");
                System.out.print("Quantity: " + slot.getQty() + " - ");
                System.out.println("Calories: " + item.getCalories());
            } else {
                System.out.println("Slot " + i + ": Empty");
            }
        }
    }

    /**
     * Receives payment in the specified denomination and quantity.
     *
     * @param denomination the denomination of the payment
     * @param quantity     the quantity of the payment
     */
    public void receivePayment(String denomination, int quantity) {
        paymentProcess.receivePayment(denomination, quantity);
    }


    /**
     * Replenishes the quantity of a specific bill denomination in the vending machine.
     *
     * @param denomination the denomination of the bill to replenish
     * @param quantity     the quantity of bills to replenish
     */
    public void replenishChange(String denomination, int quantity) {
        paymentProcess.replenishChange(denomination, quantity);
        System.out.println("Replenished change: " + quantity + " units of " + denomination);
    }

    /**
     * Dispenses an item from the specified slot number.
     *
     * @param slotNumber the slot number of the item to dispense
     * @return the dispensed item, or null if the slot is empty or the payment is insufficient
     */
    public Item dispenseItem(int slotNumber) {
        if (slotNumber >= 0 && slotNumber < slots.length) {
            Slots slot = slots[slotNumber];
            if (slot.getAvailability()) {
                if (paymentProcess.getBalance() >= slot.getPrice()) {
                    slot.setQty(slot.getQty() - 1);
                    Item item = slot.getItem();
                    paymentProcess.giveChange(paymentProcess.getBalance() - slot.getPrice());
                    int collect = paymentProcess.collectPayment();
                    System.out.println("Collected payment of: " + collect);
                    transactionLog.add(new Transaction(item, slot.getPrice()));
                    return item;
                } else {
                    System.out.println("Insufficient payment. Please insert more money.");
                }
            } else {
                System.out.println("Item not available in slot " + slotNumber);
            }
        } else {
            System.out.println("Invalid slot number");
        }
        return null;
    }

    /**
     * Restocks the item quantity in the specified slot.
     *
     * @param slotNumber the slot number to restock
     * @param qty        the quantity to add to the slot
     */
    public void restockItem(int slotNumber, int qty) {
        if (slotNumber >= 0 && slotNumber < slots.length) {
            Slots slot = slots[slotNumber];
            slot.setQty(qty);
            System.out.println("Restocked item in slot " + slotNumber + " with quantity " + qty);
        } else {
            System.out.println("Invalid slot number");
        }
    }

    /**
     * Sets the price of the item in the specified slot.
     *
     * @param slotNumber the slot number to set the price
     * @param price      the price to set for the item
     */
    public void setPrice(int slotNumber, int price) {
        if (slotNumber >= 0 && slotNumber < slots.length) {
            Slots slot = slots[slotNumber];
            slot.setPrice(price);
            System.out.println("Set price of item in slot " + slotNumber + " to " + price);
        } else {
            System.out.println("Invalid slot number");
        }
    }

    /**
     * Prints the transaction summary.
     */
    public void printTransactionSummary() {
        System.out.println("Transaction Summary:");
        for (Transaction transaction : transactionLog) {
            Item item = transaction.getItem();
            int payment = transaction.getPayment();
            System.out.println("Item: " + item.getName() + " - Payment: " + payment);
        }
    }

    /**
     * Empties the money from the vending machine, collecting the amount.
     *
     */
    public void emptyMoney() {
        paymentProcess.collectPayment();
        paymentProcess.ZeroBillDenominations();
    }
    
    /**
     * Displays the available bills and their quantities in the vending machine.
     */
    public void displayAvailableBills() {
        paymentProcess.displayAvailableBills();
    }

    /**
     * Returns the array of slots in the vending machine.
     *
     * @return the array of slots
     */
    public Slots[] getSlots() {
        return slots;
    }

    /**
     * Returns the transactionLog
     *
     * @return the arraylist of transaction logs
     */
    public ArrayList<Transaction> getTransactionLog() {
        return transactionLog;
    }

}
