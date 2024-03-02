package ProducerConsumer;

import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class SharedBuffer {

    private Queue<Integer> data;
    private boolean empty;
    private final static int MAX_SIZE = 4;
    private ReentrantLock reentrantLock = new ReentrantLock();
    private Condition notFull = reentrantLock.newCondition();
    private Condition full = reentrantLock.newCondition();

    public SharedBuffer(int buffer) {
        this.data = new LinkedList<Integer>();
        this.empty = true;
    }

    public void set(int value) {
        try {
            reentrantLock.lock();
            while (data.size() == MAX_SIZE) {
                try {
                    full.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

            notFull.signalAll();
            data.offer(value);
        } finally {
            reentrantLock.unlock();
        }
    }

    public int get() {
        try {
            reentrantLock.lock();
            while (data.size() ==0) {
                try {
                    notFull.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            empty = true;
            full.signalAll();
            return data.poll();
        } finally {
            reentrantLock.unlock();
        }
    }

    public boolean isEmpty() {
        return empty;
    }

}
