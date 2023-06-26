import java.util.Scanner;

public class VendingMachineFactory {
    private VendingMachine vendingMachine;

    public VendingMachineFactory() {
        this.vendingMachine = null;
    }

    public void start() {
        Scanner scanner = new Scanner(System.in);

        int choice = 0;
        while (choice != 3) {
            System.out.println("----- Vending Machine Factory Menu -----");
            System.out.println("1. Create new vending machine");
            System.out.println("2. Test vending machine");
            System.out.println("3. Exit program");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline character

            switch (choice) {
                case 1:
                    createVendingMachine();
                    break;
                case 2:
                    testVendingMachine();
                    break;
                case 3:
                    exitProgram();
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
                    break;
            }
        }

        scanner.close();
    }

    public void createVendingMachine() {
        // Implement the logic for creating a new vending machine
        // You can prompt the user for input or use pre-defined values
        // and initialize the VendingMachine object

        // Example:
        Slots[] slots = new Slots[8];
        PaymentProcess paymentProcess = new PaymentProcess(0);
        this.vendingMachine = new VendingMachine(slots, paymentProcess);
        System.out.println("New vending machine created successfully.");
    }

    public void testVendingMachine() {
        if (this.vendingMachine != null) {
            // Implement the logic for testing the vending machine
            // This could include displaying available items, accepting payments,
            // dispensing items, and so on
            System.out.println("Testing the vending machine...");
        } else {
            System.out.println("No vending machine created yet.");
        }
    }

    public void exitProgram() {
        System.out.println("Exiting program.");
        System.exit(0);
    }
}
