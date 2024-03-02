package assignment1;

public class Wife implements Runnable{
    private BankAccount bankAccount;

    public Wife(BankAccount bankAccount) {
        this.bankAccount = bankAccount;
    }

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            bankAccount.deposit(BankAccount.DAILY_ALLOWANCE);
        }
    }
}
