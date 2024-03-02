public class BankAccount {
    private final int accountNo;
    private double balance; //shared resource

    public BankAccount(int accountNo, double balance) {
        this.accountNo = accountNo;
        this.balance = balance;
    }

    public int getAccountNo() {
        return accountNo;
    }

    public synchronized double getBalance() {
        return balance;
    }

    public synchronized void deposit(double amount) {
        balance += amount;
        System.out.println(Thread.currentThread().getName() + " " + getBalance());
    }

    public synchronized void withdraw(double amount) {
        if (balance < amount) {
            throw new IllegalArgumentException("Insufficient fund");
        }
        balance -= amount;
        System.out.println(Thread.currentThread().getName() + " " + getBalance());
    }
}
