package assignment1;

public class Main {
    public static void main(String[] args) {

        Thread t1 = new Thread(new Test()); //NEW
        Thread t2=new Thread(new Test());
        System.out.println(t1.getState());
        System.out.println(t2.getState());

        t1.start(); //RUNNABLE
        t2.start();
        System.out.println(t1.getState());
        System.out.println(t2.getState());

        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        System.out.println("sss"+t1.getState());
    }
}