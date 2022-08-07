package code.designpatterns.composite;

public class Leaf implements Component {

    private String name;
    private int price;
    Leaf(String name,int price){
        this.name = name;
        this.price = price;
    }
    @Override
    public void showPrice() {
        System.out.println(name+" "+price);
    }
}
