import javax.swing.JOptionPane;

/**
 * Represents a special vending machine that holds slots of items and handles transactions.
 * SpecialVendingMachine extends the basic functionality of VendingMachine to handle customizable products.
 */
public class SpecialVendingMachine extends VendingMachine {

    /**
     * Constructs a SpecialVendingMachine object with the specified slots and payment process.
     *
     * @param slots          the array of slots containing items
     * @param paymentProcess the payment process for handling transactions
     */
    public SpecialVendingMachine(Slots[] slots, PaymentProcess paymentProcess) {
        super(slots, paymentProcess);
    }

    /**
     * Displays the steps for preparing the selected product based on the choices of items that the user wants.
     *
     * @param slotNumber the slot number of the selected product
     */
    public void showSteps(int slotNumber) {
        StringBuilder steps = new StringBuilder();

        if (slotNumber == 9) {
            steps.append("Get hotdog\n");
            steps.append("Put in whole wheat bread\n");
            steps.append("Add lettuce\n");
            steps.append("Add tomato");
        } else if (slotNumber == 10) {
            steps.append("Get ham\n");
            steps.append("Put in whole wheat bread\n");
            steps.append("Add lettuce\n");
            steps.append("Add tomato");
        } else if (slotNumber == 11) {
            steps.append("Get beef\n");
            steps.append("Put in whole wheat bread\n");
            steps.append("Add lettuce\n");
            steps.append("Add tomato");
        } else if (slotNumber == 12) {
            steps.append("Put in whole wheat bread\n");
            steps.append("Add lettuce\n");
            steps.append("Add tomato");
        } else {
            // For other slots, no specific steps
            steps.append("No specific steps for this item.");
        }

        // Show the steps in a message dialog
        JOptionPane.showMessageDialog(null, steps.toString(), "Preparation Steps", JOptionPane.INFORMATION_MESSAGE);
    }




}
