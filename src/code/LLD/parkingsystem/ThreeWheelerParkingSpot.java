package code.LLD.parkingsystem;

public class ThreeWheelerParkingSpot extends ParkingSpot{

    ThreeWheelerParkingSpot(){
        this.setParkingSpotType(ParkingSpotType.THREE_WHEELER);
    }

    @Override
    public int getBasePrice() {
        return 15;
    }
}
