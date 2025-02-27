import java.util.HashMap;
import java.util.Map;


/**
 * Handles the payment process in a vending machine.
 */
public class PaymentProcess {
    private int balance;
    private Map<String, Integer> billDenominations;

    /**
     * Constructs a transaction with the specified item and payment.
     *
     * @param balance    the item in the transaction
     */
    public PaymentProcess(int balance) {
        this.balance = balance;
        this.billDenominations = new HashMap<>();
        initializeBillDenominations();
    }

    // Initialize the bill denominations with initial quantities
    private void initializeBillDenominations() {
        billDenominations.put("20", 0);
        billDenominations.put("50", 0);
        billDenominations.put("100", 0);
        billDenominations.put("200", 0);
        billDenominations.put("500", 0);
        billDenominations.put("1000", 0);
    }

    public void ZeroBillDenominations() {
        billDenominations.put("20", 0);
        billDenominations.put("50", 0);
        billDenominations.put("100", 0);
        billDenominations.put("200", 0);
        billDenominations.put("500", 0);
        billDenominations.put("1000", 0);
    }


    /**
     * Receive payment in a specific denomination and update the balance.
     *
     * @param denomination the denomination of the payment
     * @param quantity     the quantity of the payment
     */
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


    /**
     * Dispenses change to the user and updates the balance.
     *
     * @param change the amount of change to dispense
     */
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


    /**
     * Replenishes the quantity of a specific bill denomination in the vending machine.
     *
     * @param denomination the denomination of the bill to replenish
     * @param quantity the quantity of bills to replenish
     */
    public void replenishChange(String denomination, int quantity) {
        if (billDenominations.containsKey(denomination)) {
            int currentQuantity = billDenominations.get(denomination);
            billDenominations.put(denomination, currentQuantity + quantity);
            System.out.println("Replenished " + quantity + " units of " + denomination);
        } else {
            System.out.println("Invalid denomination");
        }
    }


    /**
     * Collect the payment and reset the balance to zero.
     *
     * @return the collected payment amount
     */
    public int collectPayment() {
        int collectedAmount = balance;
        balance = 0;
        return collectedAmount;
    }

    // Get the amount associated with a specific denomination
    private int getDenominationAmount(String denomination) {
        switch (denomination) {
            case "20":
                return 20;
            case "50":
                return 50;
            case "100":
                return 100;
            case "200":
                return 200;
            case "500":
                return 500;
            case "1000":
                return 1000;
            default:
                return 0;
        }
    }
    /**
     * Get the current balance.
     *
     * @return the current balance
     */
    public int getBalance() {
        return balance;
    }

    /**
     * Displays the available bills and their quantities in the vending machine.
     */
    public String displayAvailableBills() {
        StringBuilder sb = new StringBuilder();
        sb.append("Available Bills:\n");
        for (Map.Entry<String, Integer> entry : billDenominations.entrySet()) {
            String denomination = entry.getKey();
            int quantity = entry.getValue();
            sb.append(denomination).append(": ").append(quantity).append("\n");
        }
        return sb.toString();
    }

}
