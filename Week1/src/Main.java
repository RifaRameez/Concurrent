public class Main {

    public static void main(String[] args) {
        System.out.println(Thread.currentThread().getName()); //current thread

        BankAccount account = new BankAccount(12345, 1000);
        Husband husband = new Husband(account, "HusbandThread");
        Wife wife = new Wife(account);
        Thread wifeThread = new Thread(wife, "WifeThread");

        husband.start();
        wifeThread.start();
    }
}