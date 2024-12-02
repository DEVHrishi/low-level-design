from typing import List
from level import Level
from vehicle import Vehicle

class ParkingLot:
    _instance = None
    
    def __init__(self):
        if ParkingLot._instance is not None:
            raise Exception("Parking Lot is a singleton instance")
        else:
            ParkingLot._instance = self
            self.levels : List[Level] = []
    
    @staticmethod
    def get_instance():
        if ParkingLot._instance is None:
            ParkingLot()
        return ParkingLot._instance
    
    def add_level(self, level: Level):
        self.levels.append(level)
    
    def park_vehicle(self, vehicle: Vehicle):
        for lvl in self.levels:
            if lvl.park_vehicle(vehicle):
                return True
        return False
    
    def unpark_vehicle(self, vehicle: Vehicle):
        for lvl in self.levels:
            if lvl.unpark_vehicle(vehicle):
                return True
        return False
    
    def display_availability(self):
        for lvl in self.levels:
            lvl.display_availability()