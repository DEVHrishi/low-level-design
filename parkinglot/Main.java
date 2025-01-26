package parkinglot;
// Main.java
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        // Initialize parking spots
        List<ParkingSpot> spots = new ArrayList<>();
        for (int i = 1; i <= 100; ++i) {
            int price = (i <= 50) ? 10 : 20;
            spots.add(new ParkingSpot(i, price));
        }

        // Create ParkingSpotManagerFactory
        ParkingSpotManagerFactory factory = new ParkingSpotManagerFactory();

        // Create EntranceGate and ExitGate objects
        EntranceGate entranceGate = new EntranceGate(factory);
        ExitGate exitGate = new ExitGate(factory);

        // Example usage
        Vehicle vehicle = new Vehicle(123, VehicleType.TwoWheeler);
        ParkingSpot spot = entranceGate.findParkingSpace(vehicle.vehicleType, spots);
        if (spot != null) {
            Ticket ticket = entranceGate.generateTicket(vehicle, spot);
            spot.parkVehicle(vehicle);
            System.out.println("Vehicle parked at spot: " + spot.id);

            // Vehicle exit
            exitGate.removeVehicle(ticket);
            System.out.println("Vehicle removed from spot: " + spot.id);
        } else {
            System.out.println("No parking spot available.");
        }
    }
}
