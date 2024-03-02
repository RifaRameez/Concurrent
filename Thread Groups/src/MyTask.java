public class MyTask implements Runnable {

    private static int sharedCounter = 0;

    @Override

    public void run() {
        for (int i = 0; i < 10; i++) {
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