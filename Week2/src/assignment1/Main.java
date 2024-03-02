package assignment1;

public class Main {
    public static void main(String[] args) {
        BankAccount sharedAccount = new BankAccount(123, 0);
        Husband husband = new Husband(sharedAccount);
        Wife wife = new Wife(sharedAccount);

        Thread husbandThread = new Thread(husband);
        Thread wifeThread = new Thread(wife);

        husbandThread.start();
        wifeThread.start();

        System.out.println("Final balance: " + sharedAccount.getBalance());
    }
}