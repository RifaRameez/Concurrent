package ProducerConsumer;

import java.util.Queue;

public class Consumer implements Runnable {
    private SharedBuffer sharedBuffer;

    public Consumer(SharedBuffer sharedBuffer) {
        this.sharedBuffer = sharedBuffer;
    }

    @Override
    public void run() {
        for (int i = 0; i < 5; i++) {
            int item = sharedBuffer.get();
            System.out.println(Thread.currentThread().getName() + " consumed " + item);

        }
    }
}
