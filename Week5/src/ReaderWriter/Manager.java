package ReaderWriter;

public class Manager implements Runnable{
    private BankAccount account;

    public Manager(BankAccount account) {
        this.account = account;
    }
    @Override
    public void run() {
        for (int i = 0; i < 5; i++) {
//            System.out.println(Thread.currentThread().getName()+" "+account.getBalance());
        }

    }
}
