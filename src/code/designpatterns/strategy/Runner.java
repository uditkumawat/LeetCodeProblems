package code.designpatterns.strategy;

//https://www.youtube.com/watch?v=u8DttUrXtEw&list=PL6W8uoQQ2c61X_9e6Net0WdYZidm7zooW&index=2
public class Runner {


    public static void main(String args[]){

        DistanceCalculationStrategyByCar distanceCalculationStrategyByCar = new DistanceCalculationStrategyByCar();
        Routing routing = new RoutingCar(distanceCalculationStrategyByCar);
        System.out.println(routing.getDistance(12,34));
        DistanceCalculationStrategyByRoad distanceCalculationStrategyByRoad = new DistanceCalculationStrategyByRoad();

        routing = new RoutingRoad(distanceCalculationStrategyByRoad);
        System.out.println(routing.getDistance(12,34));

    }
}
