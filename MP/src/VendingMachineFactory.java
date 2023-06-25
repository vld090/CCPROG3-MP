public class VendingMachineFactory {
    private VendingMachine vendingMachine;

    public VendingMachineFactory() {
        this.vendingMachine = null;
    }

    public VendingMachine createVendingMachine() {
        this.vendingMachine = new VendingMachine();
        return this.vendingMachine;
    }

    public void testVendingMachine() {
        if (this.vendingMachine != null) {
            // the testing part?
        } else {
            System.out.println("No vending machine created yet.");
        }
    }

    public void exitProgram() {
        System.out.println("Exiting program.");
        System.exit(0);
    }
}
