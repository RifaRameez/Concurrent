package assignment1;

public class Test implements Runnable{

    private String name;

    public void run() {
        try {
            Thread.sleep(1000);

        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}
