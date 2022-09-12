package code.LLD.parkingsystem;

public abstract class ParkingSpot {

    private int id;
    private boolean isEmpty;
    private Vehicle vehicle;
    private int basePrice;
    private ParkingSpotType parkingSpotType;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public boolean isEmpty() {
        return isEmpty;
    }

    public void setEmpty(boolean empty) {
        isEmpty = empty;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }

    public ParkingSpotType getParkingSpotType() {
        return parkingSpotType;
    }

    public void setParkingSpotType(ParkingSpotType parkingSpotType) {
        this.parkingSpotType = parkingSpotType;
    }

    public void parkVehicle(Vehicle vehicle){
        this.isEmpty = false;
        this.vehicle = vehicle;
    }

    public void removeVehicle(){
        this.isEmpty = true;
        this.vehicle = null;
    }

    public abstract int getBasePrice();
}
