from vehicle import Vehicle
from vehicle_type import VehicleType

class ParkingSpot:
    def __init__(self, spot_number: int, vehicle_type: VehicleType):
        self.spot_number = spot_number
        self.vehicle_type = vehicle_type # by default
        self.parked_vehicle = None
    
    def is_available(self):
        return self.parked_vehicle is None
    
    def park_vehicle(self, vehicle: Vehicle):
        if self.is_available() and vehicle.get_type() == self.vehicle_type:
            self.parked_vehicle = vehicle
        else:
            raise ValueError("parking spot not available")
    
    def unpark_vehicle(self):
        self.parked_vehicle = None
    
    def get_vehicle_type(self) -> VehicleType:
        return self.vehicle_type
    
    def get_parked_vehicle(self) -> Vehicle:
        return self.parked_vehicle
    
    def get_spot_number(self):
        return self.spot_number