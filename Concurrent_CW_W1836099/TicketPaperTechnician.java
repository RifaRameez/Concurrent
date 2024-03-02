public class TicketPaperTechnician implements Runnable {
    private String ticketTechnicianName;
    private ServiceTicketMachine serviceTicketMachine;
    private ThreadGroup ticketTechnicianThreadGroup;

    public static final int NUMBER_OF_RETRIES = 3;

    public TicketPaperTechnician(String ticketTechnicianName, ServiceTicketMachine serviceTicketMachine, ThreadGroup ticketTechnicianThreadGroup) {
        this.ticketTechnicianName = ticketTechnicianName;
        this.serviceTicketMachine = serviceTicketMachine;
        this.ticketTechnicianThreadGroup = ticketTechnicianThreadGroup;
    }

    @Override
    public void run() {
        for (int i = 0; i < NUMBER_OF_RETRIES; i++) {
            serviceTicketMachine.refillPaper();
            int waitTime = ((int) (Math.random() * (1000 - 1))) + 1;
            try {
                Thread.sleep(waitTime);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        System.out.println("Paper Technician " + this.ticketTechnicianName + " finished all the replacement, " +
                "packs of paper used ==> " + TicketMachine.replacedTonerCount);
    }
}
