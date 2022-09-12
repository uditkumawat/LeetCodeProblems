package code.designpatterns.strategy;

public class RoutingRoad extends Routing{

    RoutingRoad(DistanceCalculationStrategy distanceCalculationStrategy) {
        super(distanceCalculationStrategy);
    }
}
