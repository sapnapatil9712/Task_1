class BusTicket {
    private volatile int availableTicket = 5;
 
    public synchronized void bookTicket(String name, int ticketTobeBook) {
        while (availableTicket < ticketTobeBook) {
            System.out.println("Hi " + name + " Sorry, not enough tickets available. Waiting for tickets to be added.");
            try {
                // wait for the ticket to be available
                wait();
                addTicket(2);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        availableTicket = availableTicket - ticketTobeBook;
        System.out.println("Hi " + name + " " + ticketTobeBook + " tickets booked successfully");
        System.out.println("Available Tickets: " + availableTicket);
    }
 
    public synchronized void addTicket(int ticketTobeAdded) {
        availableTicket = availableTicket + ticketTobeAdded;//1+2=3
        System.out.println("Tickets added successfully");
        System.out.println("Available Tickets: " + availableTicket);
        notifyAll();
    }
}
 
class Passanger extends Thread {
    BusTicket busTicket;
    String name;
    int tickets;
 
    public Passanger(BusTicket busTicket, String name, int tickets) {
        this.busTicket = busTicket;
        this.name = name;
        this.tickets = tickets;
    }
 
    @Override
    public void run() {
        busTicket.bookTicket(name, tickets);
    }
}
 
public class Main {
 
    public static void main(String[] args) {
        // reference to the BusTicket class
        BusTicket busTicket = new BusTicket();
 
        // creating the object of the Passanger class
        Passanger passanger1 = new Passanger(busTicket, "Ironman", 2); // 5 availabletickets - 2 = 3
        Passanger passanger2 = new Passanger(busTicket, "Captain America", 3);  // 3 availabletickets - 3 = 0
        Passanger passanger3 = new Passanger(busTicket, "Thor", 2); // 2 availabletickets - 2 = 0
 
        Passanger passanger4 = new Passanger(busTicket, "h=Hulk", 2);
 
        Passanger passanger5 = new Passanger(busTicket, "Black Widow", 3);
 
        passanger1.start();
        passanger2.start();
        passanger3.start();
        passanger4.start();
        passanger5.start();
 
        try {
            Thread.sleep(10000);
            busTicket.addTicket(2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}