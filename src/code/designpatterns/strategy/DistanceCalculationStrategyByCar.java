package code.designpatterns.strategy;

public class DistanceCalculationStrategyByCar implements DistanceCalculationStrategy{
    @Override
    public int getDistance(int latitude, int longitude) {
        System.out.println("distance calculated by car");
        return 0;
    }
}
