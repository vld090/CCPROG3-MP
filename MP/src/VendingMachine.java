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


    public Item dispenseItem(int slotNumber){

    }


    public void restockItem(int slotNumber, int qty){

    }

    public void setPrice(int slotNumber, int qty){

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
