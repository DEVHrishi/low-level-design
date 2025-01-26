package parkinglot;

// Ticket.java
public class Ticket {
    public long entryTime;
    public ParkingSpot parkingSpot;
    public Vehicle vehicle;

    public Ticket(long entryTime, ParkingSpot parkingSpot, Vehicle vehicle) {
        this.entryTime = entryTime;
        this.parkingSpot = parkingSpot;
        this.vehicle = vehicle;
    }
}

