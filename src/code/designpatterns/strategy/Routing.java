package code.designpatterns.strategy;

public class Routing {

    DistanceCalculationStrategy distCalStrategy;

    Routing(DistanceCalculationStrategy distanceCalculationStrategy){
        this.distCalStrategy = distanceCalculationStrategy;
    }

    public int getDistance(int latitude,int longitude){
        return this.distCalStrategy.getDistance(latitude,longitude);
    }
}
