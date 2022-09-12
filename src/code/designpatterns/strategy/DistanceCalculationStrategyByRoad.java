package code.designpatterns.strategy;

public class DistanceCalculationStrategyByRoad implements DistanceCalculationStrategy{
    @Override
    public int getDistance(int latitude, int longitude) {
        System.out.println("Distance calculated by road");
        return 0;
    }
}
