public class ThreadManagementAssignment {

    public static void main(String[] args) {

        System.out.println("priority " + Thread.currentThread().getPriority());
        Thread.currentThread().setPriority(Thread.MIN_PRIORITY);

        Thread thread1 = new Thread(new MyTask(), "Thread1");
        Thread thread2 = new Thread(new MyTask(), "Thread2");

        System.out.println("current state " + thread1.getState());
        System.out.println("current state for t2 " + thread2.getState());
        System.out.println("current state " + Thread.currentThread().getState());

        thread1.setPriority(Thread.MIN_PRIORITY);
        thread1.setDaemon(true); //Background thread
        thread1.start();
//        try {
//            thread1.join();
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
        thread2.setPriority(Thread.MAX_PRIORITY);
        thread2.setDaemon(true); //Background thread
        thread2.start();

        System.out.println("current state after start " + thread1.getState());
        System.out.println("current state for t2 after start " + thread2.getState());

//        try {
//            Thread.sleep(5000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }

        System.out.println("current state after sleep " + thread1.getState());
        System.out.println("current state for t2 after sleep " + thread2.getState());




//        ThreadGroup myThreadGroup = new ThreadGroup("MyThreadGroup");
//        Thread thread1 = new Thread(myThreadGroup, new MyTask(), "Thread1");
//        Thread thread2 = new Thread(myThreadGroup, new MyTask(), "Thread2");
//        // Create more threads and assign different priorities.
//
//        thread1.setPriority(5); // Set thread1's priority to 5.
//        thread2.setPriority(Thread.NORM_PRIORITY);
//        // Set priorities for other threads.
//
//        thread1.start();
//        thread2.start();

        // Start other threads.


        // Observe thread scheduling behavior here.

    }

}