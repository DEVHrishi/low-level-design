package parkinglot;
// EntranceGate.java
import java.util.List;

public class EntranceGate {
    private ParkingSpotManagerFactory factory;

    public EntranceGate(ParkingSpotManagerFactory factory) {
        this.factory = factory;
    }

    public ParkingSpot findParkingSpace(VehicleType vehicleType, List<ParkingSpot> spots) {
        ParkingSpotManager manager = factory.getParkingSpotManager(vehicleType, spots);
        return manager.findParkingSpace();
    }

    public Ticket generateTicket(Vehicle vehicle, ParkingSpot parkingSpot) {
        long entryTime = System.currentTimeMillis();
        return new Ticket(entryTime, parkingSpot, vehicle);
    }
}

