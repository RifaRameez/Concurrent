package assignment2;

public class Main {
    public static void main(String[] args) {
        Plate plate = new Plate("qwwq");
        Son son = new Son(plate);
        Mom mom = new Mom(plate);

        Thread sonThread = new Thread(son);
        Thread mom1 = new Thread(mom);
        Thread mom2= new Thread(mom);

        mom2.start();
        mom1.start();
        System.out.println(mom1.getState());
        System.out.println(mom2.getState());
        sonThread.start();

        System.out.println(mom1.getState());
        System.out.println(mom2.getState());
    }
}
