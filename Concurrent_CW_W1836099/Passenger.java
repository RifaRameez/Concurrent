public class Passenger implements Runnable {
    private ThreadGroup passengerThreadGroup;
    private Machine machine;
    private Ticket ticket;
    private int noOfTickets;

    public Passenger(ThreadGroup passengerThreadGroup, Machine machine, int noOfTickets, Ticket ticket) {
        this.passengerThreadGroup = passengerThreadGroup;
        this.machine = machine;
        this.noOfTickets = noOfTickets;
        this.ticket = ticket;
    }

    @Override
    public void run() {
        Ticket[] ticketList = new Ticket[noOfTickets];
        for (int i = 0; i < noOfTickets; i++) {
            machine.printTicket(this.ticket);
            ticketList[i] = new Ticket(ticket.getTicketNumber(), ticket.getPassengerID(), ticket.getDestination(), ticket.getTime());
            int waitTime = ((int) (Math.random() * (1000 - 1))) + 1;
            try {
                Thread.sleep(waitTime);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}

