package assignment2;

public class Plate {

    private String food;
    private boolean foodAvailable;

    public Plate(String food) {
        this.food = food;
        this.foodAvailable = false;
    }

    public synchronized boolean isFoodAvailable() {
        return foodAvailable;
    }

    public synchronized void serveFood(String food) {
        while (!foodAvailable) {
            try {
                System.out.println("food is available: mother waiting");
                wait();
                System.out.println("food is consumed: mother out of waiting");
            } catch (InterruptedException e) {
                throw new RuntimeException();
            }
        }
        // if mother coming here, that means plate is empty
        this.food = food;
        this.foodAvailable = false;
        notifyAll();
    }

    public synchronized String consumeFood() {
        while (!foodAvailable) {
            try {
                wait();
            } catch (InterruptedException e) {
                throw new RuntimeException();
            }
        }
        this.foodAvailable = false;
        notifyAll();
        return food;
    }
}
