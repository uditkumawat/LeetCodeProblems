package code.designpatterns.composite;

import java.util.ArrayList;
import java.util.List;

public class Composite implements Component{

    private String name;
    private List<Component> components;
    Composite(String name){
        this.name = name;
        this.components = new ArrayList<>();
    }

    public void addComponent(Component component){
        this.components.add(component);
    }

    @Override
    public void showPrice() {

        System.out.println("Composite name "+name);
        for(Component component:components){
            component.showPrice();
        }
    }
}
