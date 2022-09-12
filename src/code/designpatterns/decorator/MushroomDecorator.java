package code.designpatterns.decorator;

public class MushroomDecorator extends ToppingsDecorator{

    BasePizza basePizza;

    MushroomDecorator(BasePizza basePizza){
        this.basePizza = basePizza;
    }

    @Override
    public int cost() {
        return this.basePizza.cost()+30;
    }
}
