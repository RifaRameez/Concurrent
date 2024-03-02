public class Ticket {

    private int ticketNumber;
    private String passengerID;
    private String destination;
    private String time;

    public Ticket(int ticketNumber, String passengerID, String destination, String time) {
        this.ticketNumber = ticketNumber;
        this.passengerID = passengerID;
        this.destination = destination;
        this.time = time;
    }

    public Ticket(String passengerID, String destination, String time) {
        this.passengerID = passengerID;
        this.destination = destination;
        this.time = time;
    }

    public int getTicketNumber() {
        return ticketNumber;
    }

    public String getPassengerID() {
        return passengerID;
    }

    public String getDestination() {
        return destination;
    }

    public String getTime() {
        return time;
    }

    public void setTicketNumber(int ticketNumber) {
        this.ticketNumber = ticketNumber;
    }

    @Override
    public String toString() {
        return "Ticket{" +
                "ticketNumber=" + ticketNumber +
                ", passengerID='" + passengerID + '\'' +
                ", destination='" + destination + '\'' +
                ", time='" + time + '\'' +
                '}';
    }
}
