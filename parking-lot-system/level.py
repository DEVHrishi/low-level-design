from vehicle_type import VehicleType
from typing import List
from parking_spot import ParkingSpot
from vehicle import Vehicle

class Level:
    def __init__(self, level: int, num_spot: int, vehicle_type: VehicleType):
        self.level = level
        self.parking_spots : List[ParkingSpot] = [ParkingSpot(i, vehicle_type) for i in range(num_spot)]
        
    def park_vehicle(self, vehicle: Vehicle):
        for spot in self.parking_spots:
            if spot.is_available() and spot.get_vehicle_type() == vehicle.get_type():
                spot.park_vehicle(vehicle)
                return True
        return False
    
    def unpark_vehicle(self, vehicle: Vehicle):
        for spot in self.parking_spots:
            if spot.get_parked_vehicle() == vehicle:
                spot.unpark_vehicle()
                return True
        return False
    
    def display_availability(self):
        print(f'level {self.level} availability: ')
        for spot in self.parking_spots:
            print(f'spot {spot.get_spot_number()}: {'Available' if spot.is_available() else 'occupied'}')