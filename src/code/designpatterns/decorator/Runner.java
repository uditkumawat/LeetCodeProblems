package code.designpatterns.decorator;

//https://www.youtube.com/watch?v=w6a9MXUwcfY&list=PL6W8uoQQ2c61X_9e6Net0WdYZidm7zooW&index=4
public class Runner {

    public static void main(String args[]){

        BasePizza newPizza = new VegDelight();
        System.out.println("Veg delight pizza cost " + newPizza.cost());

        newPizza = new VeggiesDecorator(new VeggiesDecorator(newPizza));
        System.out.println("Two times veggies added so cost will be "+newPizza.cost());

        newPizza = new MushroomDecorator(newPizza);
        System.out.println("Mushroom + Two times veggies added so cost will be "+newPizza.cost());

        newPizza = new ExtraCheese(newPizza);
        System.out.println("ExtraCheese + Mushroom + Two times veggies added so cost will be "+newPizza.cost());
    }
}
