package code.LLD.parkingsystem;

public class EntranceGate {

    private int gateId;
    private Ticket ticket;
    private ParkingSpotManager parkingSpotManager;

    public Ticket createTicket(){
        return new Ticket();
    }

    public ParkingSpot findParkingSpot(VehicleType vehicleType){
        return this.parkingSpotManager.findParkingSpot(vehicleType);
    }

    public void bookSpot(ParkingSpot parkingSpot){

    }
}
