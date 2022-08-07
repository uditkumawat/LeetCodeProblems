package code.designpatterns.composite;

//https://www.youtube.com/watch?v=Q1jZ4TI6MF4&list=PLsyeobzWxl7r2ZX1fl-7CKnayxHJA_1ol&index=9
public class Runner {
    public static void main(String args[]){

        Component mouse = new Leaf("Mouse",500);
        Component keyboard = new Leaf("Keyboard",2000);

        Composite peripherl = new Composite("Peripherl");

        peripherl.addComponent(mouse);
        peripherl.addComponent(keyboard);

        mouse.showPrice();
        keyboard.showPrice();

        peripherl.showPrice();
    }
}
