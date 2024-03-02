package ReaderWriter;

import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class BankAccount {
    private int accountNo;
    private double balance;

    private ReentrantReadWriteLock reentrantLock = new ReentrantReadWriteLock(true);


    public BankAccount(int accountNo, double balance) {
        this.accountNo = accountNo;
        this.balance = balance;
    }

    public int getAccountNo() {
        return accountNo;
    }

    public double getBalance() {
        try {
            reentrantLock.readLock().lock();
            System.out.println(Thread.currentThread().getName() + " balance is  " + balance);
            return balance;
        } finally {
            reentrantLock.readLock().unlock();
        }
    }

    public void deposit(double amount) {
        reentrantLock.writeLock().lock();
        balance += amount;
        System.out.println(Thread.currentThread().getName() + " " + getBalance());
        reentrantLock.writeLock().unlock();
    }

    public void withdraw(double amount) {
        if (balance < amount) {
            throw new IllegalArgumentException("Insufficient fund");
        }
        balance -= amount;
        System.out.println(Thread.currentThread().getName() + " " + getBalance());
    }
}
