package assignment1;

public class BankAccount {
    private int accountNumber;
    private double balance;

    public static final double DAILY_ALLOWANCE = 500;

    public BankAccount(int accountNumber, double balance) {
        this.accountNumber = accountNumber;
        this.balance = balance;
    }

    public int getAccountNumber() {
        return accountNumber;
    }

    public synchronized double getBalance() {
        return balance;
    }

    public synchronized void deposit(double amount) {
        if (amount < 0) {
            throw new IllegalArgumentException("Cannot deposit negative amount");
        }
        while (this.balance >= DAILY_ALLOWANCE) {
            System.out.println("Waiting for funds to be withdrawn");
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        balance += amount;
        System.out.println("assignment1.Wife deposited " + amount);
        notifyAll();
    }

    public synchronized double withdraw(double amount) throws InterruptedException {
        while (balance < amount) {
            System.out.println("Waiting for funds to be deposited");
            wait();
            if (balance >= amount) {
                balance -= amount;
                System.out.println("assignment1.Husband withdrew " + amount);
            } else {
                System.out.println("Insufficient funds");
            }
        }
        notifyAll();
        return balance;
    }
}
