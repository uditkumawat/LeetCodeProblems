package code.designpatterns.decorator;

public class ExtraCheese extends ToppingsDecorator{

    BasePizza basePizza;
    ExtraCheese(BasePizza basePizza){
        this.basePizza = basePizza;
    }
    @Override
    public int cost() {
        return this.basePizza.cost()+50;
    }
}
