public class Main {
    public static void main(String[] args) {

        LaserPrinter laserPrinter = new LaserPrinter(new Document("CW1", "Student 1", 25), "Laser Printer 1", 100, 100, 0);
        ThreadGroup studentGroup = new ThreadGroup("Students");
        ThreadGroup technicianGroup = new ThreadGroup("Technicians");

        Student student1 = new Student("Student 1", studentGroup, laserPrinter);
        Student student2 = new Student("Student 2", studentGroup, laserPrinter);
        Student student3 = new Student("Student 3", studentGroup, laserPrinter);
        Student student4 = new Student("Student 4", studentGroup, laserPrinter);

        Thread studentThread1 = new Thread(studentGroup, student1);
        Thread studentThread2 = new Thread(studentGroup, student2);
        Thread studentThread3 = new Thread(studentGroup, student3);
        Thread studentThread4 = new Thread(studentGroup, student4);

        PaperTechnician paperTechnician = new PaperTechnician("Paper Technician", technicianGroup, laserPrinter);
        TonerTechnician tonerTechnician = new TonerTechnician("Toner Technician", technicianGroup, laserPrinter);

        Thread paperTechnicianThread = new Thread(technicianGroup, paperTechnician);
        Thread tonerTechnicianThread = new Thread(technicianGroup, tonerTechnician);

        studentThread1.start();
        studentThread2.start();
        studentThread3.start();
        studentThread4.start();

        paperTechnicianThread.start();
        tonerTechnicianThread.start();

        while (studentGroup.activeCount() > 0 && technicianGroup.activeCount() > 0) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }
}