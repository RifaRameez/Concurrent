public class Wife implements Runnable {

    private BankAccount account;

    public Wife(BankAccount account) {
        this.account = account;
    }

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            account.deposit(100);
            //System.out.println(Thread.currentThread().getName()+" "+account.getBalance());
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}