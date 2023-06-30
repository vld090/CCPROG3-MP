import java.util.HashMap;
import java.util.Map;

public class PaymentProcess {
    private int balance;
    private Map<String, Integer> billDenominations;

    public PaymentProcess(int balance) {
        this.balance = balance;
        this.billDenominations = new HashMap<>();
        initializeBillDenominations();
    }

    // Initialize the bill denominations with initial quantities
    private void initializeBillDenominations() {
        billDenominations.put("P20", 0);
        billDenominations.put("P50", 0);
        billDenominations.put("P100", 0);
        billDenominations.put("P200", 0);
        billDenominations.put("P500", 0);
        billDenominations.put("P1000", 0);
    }

    // Receive payment in a specific denomination and update the balance
    public void receivePayment(String denomination, int quantity) {
        if (billDenominations.containsKey(denomination)) {
            int currentQuantity = billDenominations.get(denomination);
            billDenominations.put(denomination, currentQuantity + quantity);
            int amount = getDenominationAmount(denomination) * quantity;
            balance += amount;
            System.out.println("Received payment of " + amount);
        } else {
            System.out.println("Invalid denomination");
        }
    }

    // Give change to the user based on the requested amount
    public void giveChange(int change) {
        if (balance >= change) {
            if (hasSufficientChange(change)) {
                balance -= change;
                distributeChange(change);
                System.out.println("Dispensed change of " + change);
            } else {
                System.out.println("Insufficient change in the machine");
            }
        } else {
            System.out.println("Insufficient balance to provide change");
        }
    }

    // Check if the machine has sufficient change to provide
    private boolean hasSufficientChange(int change) {
        return balance >= change && change <= getTotalChange();
    }

    // Calculate the total change available in the machine
    private int getTotalChange() {
        int totalChange = 0;
        for (Map.Entry<String, Integer> entry : billDenominations.entrySet()) {
            String denomination = entry.getKey();
            int quantity = entry.getValue();
            totalChange += getDenominationAmount(denomination) * quantity;
        }
        return totalChange;
    }

    // Distribute the change to the user using available bill denominations
    private void distributeChange(int change) {
        for (Map.Entry<String, Integer> entry : billDenominations.entrySet()) {
            String denomination = entry.getKey();
            int quantity = entry.getValue();
            int denominationAmount = getDenominationAmount(denomination);
            while (change >= denominationAmount && quantity > 0) {
                change -= denominationAmount;
                quantity--;
                System.out.println("Dispensed " + denomination);
            }
            billDenominations.put(denomination, quantity);
            if (change == 0) {
                break;
            }
        }
    }

    // Replenish the quantity of a specific bill denomination
    public void replenishChange(String denomination, int quantity) {
        if (billDenominations.containsKey(denomination)) {
            int currentQuantity = billDenominations.get(denomination);
            billDenominations.put(denomination, currentQuantity + quantity);
            System.out.println("Replenished " + quantity + " units of " + denomination);
        } else {
            System.out.println("Invalid denomination");
        }
    }

    // Collect the payment and reset the balance to zero
    public int collectPayment() {
        int collectedAmount = balance;
        balance = 0;
        System.out.println("Collected payment of: " + collectedAmount);
        return collectedAmount;
    }

    // Get the amount associated with a specific denomination
    private int getDenominationAmount(String denomination) {
        switch (denomination) {
            case "P20":
                return 20;
            case "P50":
                return 50;
            case "P100":
                return 100;
            case "P200":
                return 200;
            case "P500":
                return 500;
            case "P1000":
                return 1000;
            default:
                return 0;
        }
    }

    public int getBalance() {
        return balance;
    }

}
