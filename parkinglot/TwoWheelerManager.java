package parkinglot;

// TwoWheelerManager.java
import java.util.List;

public class TwoWheelerManager extends ParkingSpotManager {
    public TwoWheelerManager(List<ParkingSpot> spots) {
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
