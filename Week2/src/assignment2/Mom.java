package assignment2;

public class Mom implements Runnable {

    private Plate plate;

    public Mom(Plate plate) {
        this.plate = plate;
    }

    public void run() {
        for (int i = 0; i < 10; i++) {
            plate.consumeFood();
        }
    }
}
