import java.util.Scanner;
/**
 * Factory class for creating and testing vending machines.
 */
public class VendingMachineFactory {
    private VendingMachine vendingMachine;

    /**
     * Constructs a VendingMachineFactory object.
     */
    public VendingMachineFactory() {
        this.vendingMachine = null;
    }

    /**
     * Starts the vending machine factory menu.
     */
    public void start() {
        Scanner scanner = new Scanner(System.in);

        int choice = 0;
        while (choice != 4) {
            System.out.println("----- Vending Machine Factory Menu -----");
            System.out.println("1. Create new vending machine");
            System.out.println("2. Test vending machine");
            System.out.println("3. Test special vending machine features");
            System.out.println("4. Exit program");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    createVendingMachine();
                    break;
                case 2:
                    testVendingMachine();
                    break;
                case 3:
                    testSpecialVendingMachine();
                    break;
                case 4:
                    exitProgram();
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
                    break;
            }
        }

        scanner.close();
    }

    /**
     * Creates new vending machine
     *
     * @return
     */
    public VendingMachine createVendingMachine() {
        this.vendingMachine = VendingMachineDirector.createStandardVendingMachine().build();
        return this.vendingMachine;

    }

    /**
     * Creates a new special vending machine.
     */
    public VendingMachine createSpecialVendingMachine() {
        this.vendingMachine = VendingMachineDirector.createSpecialVendingMachine().build();
        return this.vendingMachine;
    }

    /**
     * Tests the vending machine.
     */
    public void testVendingMachine() {
        if (this.vendingMachine != null) {
            Scanner scanner = new Scanner(System.in);

            while (true) {
                System.out.println("----- Vending Machine Testing Menu -----");
                System.out.println("1. Display available items");
                System.out.println("2. Insert payment");
                System.out.println("3. Select slot and dispense item");
                System.out.println("4. Replenish item quantity");
                System.out.println("5. Set item price");
                System.out.println("6. Print transaction summary");
                System.out.println("7. Display available bills");
                System.out.println("8. Replenish change denominations");
                System.out.println("9. Collect Money");
                System.out.println("10.Exit Testing");

                System.out.print("Enter your choice: ");
                int choice = scanner.nextInt();
                scanner.nextLine(); // Consume newline character

                switch (choice) {
                    case 1:
                        this.vendingMachine.displayItems();
                        break;

                    case 2:
                        System.out.println("Only Accepts: P20, P50, P100, P200, P500, P1000");
                        System.out.print("Enter denomination: ");
                        String denomination = scanner.nextLine();
                        System.out.print("Enter quantity: ");
                        int quantity = scanner.nextInt();
                        this.vendingMachine.receivePayment(denomination, quantity);
                        break;

                    case 3:
                        System.out.print("Enter slot number: ");
                        int slotNumber = scanner.nextInt();
                        scanner.nextLine(); // Consume newline character
                        Item item = this.vendingMachine.dispenseItem(slotNumber);
                        if (item != null) {
                            System.out.println("Dispensed item: " + item.getName());
                        }
                        break;

                    case 4:
                        System.out.print("Enter slot number: ");
                        int restockSlotNumber = scanner.nextInt();
                        System.out.print("Enter quantity: ");
                        int restockQty = scanner.nextInt();
                        if (restockQty >= 0) {
                            this.vendingMachine.restockItem(restockSlotNumber, restockQty);
                        } else {
                            System.out.println("Invalid quantity. Quantity must be non-negative.");
                        }
                        break;
                    case 5:
                        System.out.print("Enter slot number: ");
                        int setPriceSlotNumber = scanner.nextInt();
                        System.out.print("Enter price: ");
                        int setPrice = scanner.nextInt();
                        if (setPrice >= 0) {
                            this.vendingMachine.setPrice(setPriceSlotNumber, setPrice);
                        } else {
                            System.out.println("Invalid price. Price must be non-negative.");
                        }
                        break;
                    case 6:
                        this.vendingMachine.printTransactionSummary();
                        break;

                    case 7:
                        this.vendingMachine.displayAvailableBills();
                        break;

                    case 8: // Add case for replenishing change denominations
                        System.out.print("Enter denomination to replenish: ");
                        String replenishDenomination = scanner.nextLine();
                        System.out.print("Enter quantity: ");
                        int replenishQuantity = scanner.nextInt();
                        this.vendingMachine.replenishChange(replenishDenomination, replenishQuantity);
                        break;

                    case 9:
                        this.vendingMachine.emptyMoney();
                        break;

                    case 10: // Update the case number for exit
                        System.out.println("Exiting testing.");
                        return;

                    default:
                        System.out.println("Invalid choice. Please try again.");
                        break;
                }
            }
        } else {
            System.out.println("No vending machine created yet.");
        }
    }

    public void testSpecialVendingMachine() {
        this.vendingMachine = createSpecialVendingMachine();
        GUI gui = new GUI(vendingMachine);
    }

    /**
     * Exit the Program
     */
    public void exitProgram() {
        System.out.println("Exiting program.");
        System.exit(0);
    }
}
