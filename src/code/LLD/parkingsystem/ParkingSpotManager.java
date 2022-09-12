package code.LLD.parkingsystem;

import java.util.List;

public class ParkingSpotManager {

    private List<ParkingSpot> parkingSpots;
    private ParkingSpotFindingStrategy parkingSpotFindingStrategy;

    ParkingSpotManager(ParkingSpotFindingStrategy parkingSpotFindingStrategy){
        this.parkingSpotFindingStrategy = parkingSpotFindingStrategy;
    }

    public List<ParkingSpot> getParkingSpots() {
        return parkingSpots;
    }

    public void setParkingSpots(List<ParkingSpot> parkingSpots) {
        this.parkingSpots = parkingSpots;
    }

    public ParkingSpot findParkingSpot(VehicleType vehicleType){
        return parkingSpotFindingStrategy.findParkingSpot(vehicleType);
    }

    public void addParkingSpot(ParkingSpot parkingSpot){
        this.parkingSpots.add(parkingSpot);
    }

    public void parkVehicle(Vehicle vehicle){

    }

    public void removeVehicle(Vehicle vehicle){

    }
}
