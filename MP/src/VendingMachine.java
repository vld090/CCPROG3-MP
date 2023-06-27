import java.util.ArrayList;

public class VendingMachine {
    private Slots[] slots;
    private ArrayList<Transaction> transactionLog;
    private PaymentProcess paymentProcess;


    public VendingMachine(Slots[] slots, PaymentProcess paymentProcess){
        this.slots = slots;
        this.paymentProcess = paymentProcess;
        this.transactionLog = new ArrayList<>();
    }

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

    public void receivePayment(int payment){
        paymentProcess.receivePayment(payment);
    }

    public void produceChange(int amount){
        paymentProcess.giveChange(amount);
    }

    public int collectPayment(){
        return paymentProcess.collectPayment();
    }

    public void replenishChange(int denomination, int amount) {
        paymentProcess.replenishChange(denomination, amount);
        System.out.println("Replenished change: " + amount + " units of " + denomination);
    }


    public Item dispenseItem(int slotNumber) {
        if (slotNumber >= 0 && slotNumber < slots.length) {
            Slots slot = slots[slotNumber];
            if (slot.getAvailability()) {
                slot.setQty(slot.getQty() - 1);
                Item item = slot.getItem();
                System.out.println("Dispensing " + item.getName() + " from slot " + slotNumber);
                return item;
            } else {
                System.out.println("Item not available in slot " + slotNumber);
            }
        } else {
            System.out.println("Invalid slot number");
        }
        return null;
    }



    public void restockItem(int slotNumber, int qty) {
        if (slotNumber >= 0 && slotNumber < slots.length) {
            Slots slot = slots[slotNumber];
            slot.setQty(slot.getQty() + qty);
            System.out.println("Restocked item in slot " + slotNumber + " with quantity " + qty);
        } else {
            System.out.println("Invalid slot number");
        }
    }

    public void setPrice(int slotNumber, int price) {
        if (slotNumber >= 0 && slotNumber < slots.length) {
            Slots slot = slots[slotNumber];
            slot.setPrice(price);
            System.out.println("Set price of item in slot " + slotNumber + " to " + price);
        } else {
            System.out.println("Invalid slot number");
        }
    }


    public void printTransactionSummary() {
        System.out.println("Transaction Summary:");
        for (Transaction transaction : transactionLog) {
            Item item = transaction.getItem();
            int payment = transaction.getPayment();
            System.out.println("Item: " + item.getName() + " - Payment: " + payment);
        }
    }



}
