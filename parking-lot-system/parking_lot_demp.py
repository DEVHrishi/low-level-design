from vehicle_type import VehicleType
from parking_lot import ParkingLot
from level import Level
from car import Car
from truck import Truck
from motorcycle import MotorCycle

class Demo:
    def run(self):
        parkingLot = ParkingLot.get_instance()
        parkingLot.add_level(Level(1, 5, VehicleType.CAR))
        parkingLot.add_level(Level(2, 3, VehicleType.TRUCK))
        parkingLot.add_level(Level(3, 3, VehicleType.MOTORCYCLE))
        
        car = Car('aafi4')
        truck = Truck('akdoi5')
        motorcycle = MotorCycle('adfio3')
        
        print(parkingLot.park_vehicle(car))
        print(parkingLot.park_vehicle(truck))
        print(parkingLot.park_vehicle(motorcycle))
        
        parkingLot.display_availability()
        
        print(parkingLot.unpark_vehicle(car))
        
        parkingLot.display_availability()
        
if __name__ == "__main__":
    d = Demo()
    d.run()