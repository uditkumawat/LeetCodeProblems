package code.LLD.parkingsystem;

public class FourWheelerParkingSpot extends ParkingSpot{

    FourWheelerParkingSpot(){
        this.setParkingSpotType(ParkingSpotType.FOUR_WHEELER);
    }

    @Override
    public int getBasePrice() {
        return 40;
    }
}
