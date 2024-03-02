package assignment1;

public class Husband implements Runnable{
    private BankAccount bankAccount;

    public Husband(BankAccount bankAccount) {
        this.bankAccount = bankAccount;
    }

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            try {
                bankAccount.withdraw(BankAccount.DAILY_ALLOWANCE);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
