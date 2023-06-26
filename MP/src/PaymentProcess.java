public class PaymentProcess {
    private int balance;

    public PaymentProcess(int balance){
        this.balance = balance;
    }

    public void receivePayment(int payment){
        balance += payment;
        System.out.println("Received payment of " + payment);
    }

    public void giveChange(int change){
        if (balance >= change) {
            balance -= change;
            System.out.println("Dispensed change of " + change);
        } else {
            System.out.println("Insufficient balance to provide change.");
        }
    }

    public void replenishChange(int change, int amount){
        balance += change;
        System.out.println("Replenished balance by " + change);
    }

    public int collectPayment() {
        int collectedAmount = balance;
        balance = 0;
        return collectedAmount;
    }
}
