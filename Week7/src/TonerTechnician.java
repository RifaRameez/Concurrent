public class TonerTechnician implements Runnable {
    private String name;
    private ThreadGroup threadGroup;
    private ServicePrinter servicePrinter ;

    public TonerTechnician(String name, ThreadGroup threadGroup, ServicePrinter printer) {
        this.name = name;
        this.threadGroup = threadGroup;
        this.servicePrinter = printer;
    }

    @Override
    public void run() {
        for (int i = 0; i < 3; i++) {
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            servicePrinter.replaceTonerCartridge();
            System.out.println(name+ " has refilled the paper tray");
        }
    }
}
