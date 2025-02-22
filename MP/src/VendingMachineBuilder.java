import java.util.ArrayList;

public class VendingMachineBuilder {
    private ArrayList<Slots> slots;
    private PaymentProcess paymentProcess;
    private VendingMachine vendingMachine;

    // constructor
    public VendingMachineBuilder() {
        this.slots = new ArrayList<Slots>(); 
        this.paymentProcess = new PaymentProcess(0);
        vendingMachine = new VendingMachine();
    }

    public void addItem(Item item, int price, int qty) {
        slots.add(new Slots(item, price, qty));
        
    }

    public void addPaymentProcess(PaymentProcess paymentProcess) {
        this.paymentProcess = paymentProcess;
    }

    public VendingMachine build() {
        slots.add(new Slots(new Item("Skip", 0), 0, 10));
        vendingMachine.setSlots(this.slots);
        vendingMachine.setPaymentProcess(paymentProcess);
        return vendingMachine;
    }
}

