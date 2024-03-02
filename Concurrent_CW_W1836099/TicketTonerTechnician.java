public class TicketTonerTechnician implements Runnable {

    private String tonerTechnicianName;
    private ServiceTicketMachine serviceTicketMachine;
    private ThreadGroup tonerTechnicianThreadGroup;

    public static final int NUMBER_OF_RETRIES = 3;

    public TicketTonerTechnician(String tonerTechnicianName, ServiceTicketMachine serviceTicketMachine, ThreadGroup tonerTechnicianThreadGroup) {
        this.tonerTechnicianName = tonerTechnicianName;
        this.serviceTicketMachine = serviceTicketMachine;
        this.tonerTechnicianThreadGroup = tonerTechnicianThreadGroup;
    }

    @Override
    public void run() {
        for (int i = 0; i < NUMBER_OF_RETRIES; i++) {
                serviceTicketMachine.replaceTonerCartridge();
            int waitTime = ((int) (Math.random() * (1000 - 1))) + 1;
            try {
                Thread.sleep(waitTime);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        System.out.println("Toner Technician " + this.tonerTechnicianName + " finished all the replacement, " +
                "cartridges used ==> " + TicketMachine.refilledPaperPackCount);
    }
}
