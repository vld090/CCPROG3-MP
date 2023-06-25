public class PaymentProcess {
    private int balance;

    public PaymentProcess(int balance){
        this.balance = balance;
    }

    public void receivePayment(int payment){

    }

    public void giveChange(int change){

    }

    public void replenishChange(int change){

    }
    public int collectPayment() {
        int collected = balance;
        balance = 0;
        return collected;
    }
}
