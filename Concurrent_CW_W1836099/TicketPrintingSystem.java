import java.math.BigDecimal;

public class TicketPrintingSystem {
    public static void main(String[] args) {

        Ticket ticket = new Ticket("PASS1", "Colombo", "9:00");
        Ticket ticket2 = new Ticket("PASS2", "Galle", "13:00");
        Ticket ticket3 = new Ticket("PASS3", "Kandy", "15:00");
        Ticket ticket4 = new Ticket("PASS4", "Matara", "15:00");


        ServiceTicketMachine ticketMachine = new TicketMachine(10, 1, 0);

        ThreadGroup[] ticketMachineThreadGroups = new ThreadGroup[2];
        ticketMachineThreadGroups[0] = new ThreadGroup("Passenger Thread Group");
        ticketMachineThreadGroups[1] = new ThreadGroup("Technician Thread Group");

        Runnable[] ticketMachineRunnable = new Runnable[6];
        ticketMachineRunnable[0] = new Passenger(ticketMachineThreadGroups[0], ticketMachine, 2, ticket);
        ticketMachineRunnable[1] = new Passenger(ticketMachineThreadGroups[0], ticketMachine, 3, ticket2);
        ticketMachineRunnable[2] = new Passenger(ticketMachineThreadGroups[0], ticketMachine, 4, ticket3);
        ticketMachineRunnable[3] = new Passenger(ticketMachineThreadGroups[0], ticketMachine, 5, ticket4);
        ticketMachineRunnable[4] = new TicketPaperTechnician("Paper001", ticketMachine, ticketMachineThreadGroups[1]);
        ticketMachineRunnable[5] = new TicketTonerTechnician("Toner001", ticketMachine, ticketMachineThreadGroups[1]);

        Thread[] ticketMachineThreads = new Thread[6];
        ticketMachineThreads[0] = new Thread(ticketMachineThreadGroups[0], ticketMachineRunnable[0], "PASS1");
        ticketMachineThreads[1] = new Thread(ticketMachineThreadGroups[0], ticketMachineRunnable[1], "PASS2");
        ticketMachineThreads[2] = new Thread(ticketMachineThreadGroups[0], ticketMachineRunnable[2], "PASS3");
        ticketMachineThreads[3] = new Thread(ticketMachineThreadGroups[0], ticketMachineRunnable[3], "PASS4");
        ticketMachineThreads[4] = new Thread(ticketMachineThreadGroups[1], ticketMachineRunnable[4], "Paper001");
        ticketMachineThreads[5] = new Thread(ticketMachineThreadGroups[1], ticketMachineRunnable[5], "Toner001");

        for (Thread thread : ticketMachineThreads) {
            thread.start();
        }

        for (Thread thread : ticketMachineThreads) {
            try {
                thread.join();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
