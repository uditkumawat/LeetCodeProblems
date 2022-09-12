package code.LLD.parkingsystem;

public class TwoWheelerParkingSpot extends ParkingSpot{

    public TwoWheelerParkingSpot(){
        this.setParkingSpotType(ParkingSpotType.TWO_WHEELER);
    }

    @Override
    public int getBasePrice() {
        return 20;
    }
}
