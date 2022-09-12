package code.designpatterns.strategy;

public class RoutingCar extends Routing{


    RoutingCar(DistanceCalculationStrategy distanceCalculationStrategy) {
        super(distanceCalculationStrategy);
    }

}
