public class MyTask implements Runnable {

    private static int sharedCounter = 0;

    @Override
    public void run() {
        // two threadgroups will be created since t1 and t2 runs as same body
//        ThreadGroup threadGroup = new ThreadGroup("MyThreadGroup 2");
//        System.out.println("Thread Group Name : " + threadGroup.getName());
//        System.out.println("Thread Group Parent Name : " + threadGroup.getParent().getName());

        for (int i = 0; i < 5; i++) {
            synchronized (MyTask.class) {
                sharedCounter++;
                System.out.println(Thread.currentThread().getName() + " - Counter: " + sharedCounter);
            }

            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}