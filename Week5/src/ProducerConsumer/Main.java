package ProducerConsumer;

public class Main {
    public static void main(String[] args) {
        SharedBuffer sharedBuffer = new SharedBuffer(0);
        Producer producer1 = new Producer(sharedBuffer);
        Producer producer2 = new Producer(sharedBuffer);
        Producer producer3 = new Producer(sharedBuffer);
        Producer producer4 = new Producer(sharedBuffer);

        Consumer consumer1 = new Consumer(sharedBuffer);
        Consumer consumer2 = new Consumer(sharedBuffer);
        Consumer consumer3 = new Consumer(sharedBuffer);
        Consumer consumer4 = new Consumer(sharedBuffer);

        Thread producerThread1 = new Thread(producer1, "Producer1");
        Thread producerThread2 = new Thread(producer2, "Producer2");
        Thread producerThread3 = new Thread(producer3, "Producer3");
        Thread producerThread4 = new Thread(producer4, "Producer4");

        Thread consumerThread1 = new Thread(consumer1, "Consumer1");
        Thread consumerThread2 = new Thread(consumer2, "Consumer2");
        Thread consumerThread3 = new Thread(consumer3, "Consumer3");
        Thread consumerThread4 = new Thread(consumer4, "Consumer4");

        producerThread1.start();
        producerThread2.start();
        producerThread3.start();
        producerThread4.start();

        consumerThread1.start();
        consumerThread2.start();
        consumerThread3.start();
        consumerThread4.start();
    }
}