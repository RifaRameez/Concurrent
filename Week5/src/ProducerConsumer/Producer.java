package ProducerConsumer;


public class Producer implements Runnable {
    private SharedBuffer sharedBuffer;

    public Producer(SharedBuffer sharedBuffer) {
        this.sharedBuffer = sharedBuffer;
    }

    @Override
    public void run() {
        for (int i = 0; i < 5; i++) {
            sharedBuffer.set(i);
            System.out.println(Thread.currentThread().getName() + " produced " + i);
        }
    }
}
