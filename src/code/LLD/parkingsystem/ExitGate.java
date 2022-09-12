package code.LLD.parkingsystem;

import java.util.Date;

public class ExitGate {

    private ParkingSpotManager parkingSpotManager;
    private CostComputation costComputation;
    private Date exitTime;
    private Ticket ticket;
    private Payment payment;
    private Vehicle vehicle;

    public int costComputation(Ticket ticket){
        return costComputation.calculateCost(ticket);
    }

    public void freeParkingSpace(){
        this.parkingSpotManager.removeVehicle(vehicle);
    }
}
