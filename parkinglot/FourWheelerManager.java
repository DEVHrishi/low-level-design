package parkinglot;

// FourWheelerManager.java
import java.util.List;

public class FourWheelerManager extends ParkingSpotManager {
    public FourWheelerManager(List<ParkingSpot> spots) {
        super(spots);
    }

    @Override
    public ParkingSpot findParkingSpace() {
        for (ParkingSpot spot : spots) {
            if (spot.isEmpty) {
                return spot;
            }
        }
        return null;
    }
}

