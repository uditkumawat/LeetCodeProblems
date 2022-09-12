package code.designpatterns.decorator;

public class VeggiesDecorator extends ToppingsDecorator{

    BasePizza basePizza;

    VeggiesDecorator(BasePizza basePizza){
        this.basePizza = basePizza;
    }

    @Override
    public int cost() {
        return this.basePizza.cost()+10;
    }
}
