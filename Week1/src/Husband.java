public class Husband extends Thread {

    private BankAccount account;

    public Husband(BankAccount account, String name) {
        super(name);
        this.account = account;
    }

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            account.withdraw(100);
            try {
                Thread.sleep(1000);
                //System.out.println(Thread.currentThread().getName()+" "+account.getBalance());
            } catch (InterruptedException e) {
                System.out.println("Insufficient balance");
            }
        }
    }

}