public class Student implements Runnable {

    private String name;
    private ThreadGroup threadGroup;
    private Printer printer;

    public Student(String name, ThreadGroup threadGroup, Printer printer) {
        this.name = name;
        this.threadGroup = threadGroup;
        this.printer = printer;
    }

    @Override
    public void run() {
        for (int i = 0; i < 5; i++) {
            printer.printDocument(new Document(name, "CW1", 25));
            System.out.println(name+ " has printed " + i + " documents");
        }
    }

}
