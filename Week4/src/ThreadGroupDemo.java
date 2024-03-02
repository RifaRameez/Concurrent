public class ThreadGroupDemo {
    public static void main(String[] args) {
        ThreadGroup[] threadGroups = new ThreadGroup[6];
        Thread[] threads = new Thread[7];
        threads[0] = Thread.currentThread();
        threadGroups[0] = threads[0].getThreadGroup();

        threadGroups[1] = new ThreadGroup("MyThreadGroup A");
        threadGroups[2] = new ThreadGroup("MyThreadGroup B");
        threadGroups[3] = new ThreadGroup("MyThreadGroup C");

        threads[1] = new Thread(threadGroups[1], new MyTask(), "Thread 2");

        threads[2] = new Thread(threadGroups[1], new MyTask(), "Thread 3");

        threads[3] = new Thread(threadGroups[3], new MyTask(), "Thread 4");

        threadGroups[4] = new ThreadGroup(threadGroups[2], "MyThreadGroup B1");

        threads[4] = new Thread(threadGroups[4], new MyTask(), "Thread 5");

        threads[5] = new Thread(threadGroups[4], new MyTask(), "Thread 6");

        threadGroups[5] = new ThreadGroup(threadGroups[2], "MyThreadGroup B2");

        threads[6] = new Thread(threadGroups[5], new MyTask(), "Thread 7");


        System.out.println("Active count before start: " + Thread.currentThread().getThreadGroup().activeCount());
        System.out.println("Active group count before start: " + Thread.currentThread().getThreadGroup().activeGroupCount());

        for (int i = 1; i < threads.length; i++) {
            if (i % 2 == 0)
                threads[i].setPriority(Thread.MAX_PRIORITY);
            threads[i].start();
            System.out.println(threads[i].getThreadGroup().getName() + threads[i].getName() + " priority: " + threads[i].getPriority());
        }

        threadGroups[2].setMaxPriority(Thread.NORM_PRIORITY);

        for (int i = 1; i < threads.length; i++) {
            System.out.println(threads[i].getThreadGroup().getName() + threads[i].getName() + " priority: " + threads[i].getPriority());
        }

        System.out.println("Active count after start : " + Thread.currentThread().getThreadGroup().activeCount());
        System.out.println("Active group count after start: " + Thread.currentThread().getThreadGroup().activeGroupCount());

        Thread[] newThreads = new Thread[Thread.currentThread().getThreadGroup().activeCount() * 2];
        Thread.currentThread().getThreadGroup().enumerate(newThreads);

        ThreadGroup[] newThreadGroups = new ThreadGroup[Thread.currentThread().getThreadGroup().activeGroupCount() * 2];
        Thread.currentThread().getThreadGroup().enumerate(newThreadGroups);

        for (Thread thread : newThreads) {
            if (thread != null)
                System.out.println("Enumerate threads " + thread.getName());
        }

        for (ThreadGroup threadGroup : newThreadGroups) {
            if (threadGroup != null)
                System.out.println("Enumerated threadgroups" + threadGroup.getName());
        }
    }
}
