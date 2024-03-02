public class ThreadGroupTest {
    public static void main(String[] args) {

        System.out.println("Thread Name : " + Thread.currentThread().getName()); //Main Thread(1)
        System.out.println("Thread Group Name : " + Thread.currentThread().getThreadGroup().getName()); //Main Thread Group(1)
        System.out.println("Thread Group Parent Name : " + Thread.currentThread().getThreadGroup().getParent().getName());

        //ThreadGroup(2)
        ThreadGroup threadGroup = new ThreadGroup("MyThreadGroup 1"); //this thread group is created by the main thread so MyThreadGroup parent name belongs to main too
        System.out.println("Thread Group Name : " + threadGroup.getName());
        System.out.println("Thread Group Parent Name : " + threadGroup.getParent().getName());

        //Thread(2)
        Thread t1 = new Thread(threadGroup, new MyTask(), "t1"); // to which thread group does this thread belong to? main thread group
        t1.start();
        System.out.println("Thread Name : " + t1.getName());
        System.out.println("Thread Group Name : " + t1.getThreadGroup().getName());

        //ThreadGroup(3)
        ThreadGroup threadGroup3 = new ThreadGroup(threadGroup, "MyThreadGroup 3");
        System.out.println("Thread Group Name : " + threadGroup3.getName());
        System.out.println("Thread Group Parent Name : " + threadGroup3.getParent().getName());

        //Thread(3)
        Thread t2 = new Thread(threadGroup3, new MyTask(), "t2");
        t2.start();
        System.out.println("Thread Name : " + t2.getName());
        System.out.println("Thread Group Name : " + t2.getThreadGroup().getName());


    }
}
