import java.util.HashMap;
import java.util.Map;

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
     * Prepares a selected product based on the choices of items that the user wants.
     * The amount of calories for the final product is the combination of the calorie count
     * of each chosen item to include (which might involve more than just addition).
     * The preparation process will be displayed step by step.
     *
     * @param productChoices a map containing the slot numbers and quantities of chosen items for the product
     */
    public void prepareProduct(Map<Integer, Integer> productChoices) {
        System.out.println("Preparing the selected product...");
        int totalCalories = 0;

        for (Map.Entry<Integer, Integer> entry : productChoices.entrySet()) {
            int slotNumber = entry.getKey();
            int quantity = entry.getValue();

            if (slotNumber >= 0 && slotNumber < getSlots().length) {
                Slots slot = getSlots()[slotNumber];
                Item item = slot.getItem();
                if (item != null) {
                    System.out.println("Adding " + quantity + " unit(s) of " + item.getName() + " to the product.");
                    totalCalories += item.getCalories() * quantity;
                }
            }
        }

        System.out.println("Total calories of the product: " + totalCalories);
        System.out.println("Product preparation completed.");
    }

}
