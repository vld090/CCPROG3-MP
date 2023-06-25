import java.util.ArrayList;

public class VendingMachine {
    private Slots[] slots;
    private ArrayList<Transaction> transactionLog;
    private PaymentProcess paymentProcess;


    public VendingMachine(Slots[] slots, PaymentProcess paymentProcess){
        this.slots = slots;
        this.paymentProcess = paymentProcess;
    }

    public void displayItems(){

    }

    public void receivePayment(int payment){

    }

    public Item dispenseItem(int slotNumber){

    }

    public void produceChange(int amount){

    }

    public void restockItem(int slotNumber, int qty){

    }

    public void setPrice(int slotNumber, int qty){

    }

    public int collectPayment(){

    }

    public void replenishChange(int amount){

    }

    public void printTransactionSummary(){

    }



}
