public class ThreadManagementAssignment {

    public static void main(String[] args) {
        ThreadGroup myThreadGroup = new ThreadGroup("MyThreadGroup");

        Thread thread1 = new Thread(myThreadGroup, new MyTask(), "Thread1");
        Thread thread2 = new Thread(myThreadGroup, new MyTask(), "Thread2");
        Thread thread3 = new Thread(myThreadGroup, new MyTask(), "Thread3");
        Thread thread4 = new Thread(myThreadGroup, new MyTask(), "Thread4");
        Thread thread5 = new Thread(myThreadGroup, new MyTask(), "Thread5");

        thread1.setPriority(5); // Set thread1's priority to 5.
        thread2.setPriority(Thread.MAX_PRIORITY);
        thread3.setPriority(Thread.MIN_PRIORITY);
        thread4.setPriority(3);
        thread5.setPriority(7);

        thread1.start();
        thread2.start();
        thread3.start();
        thread4.start();
        thread5.start();
    }

}