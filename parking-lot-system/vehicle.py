from abc import ABC
from vehicle_type import VehicleType

class Vehicle(ABC):
    def __init__(self, license_plate: int, vehicle_type: VehicleType):
        self.license_plate = license_plate
        self.type = vehicle_type
    
    def get_type(self):
        return self.type