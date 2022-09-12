package code.designpatterns.observer;

public class Subscriber implements Observer {

    private String name;
    private Channel channel;

    public Subscriber(String name){
        this.name = name;
    }

    @Override
    public void update(){
        System.out.println("Notified Subscriber "+name);
    }

    public void subscribeChannel(Channel ch){
        this.channel = ch;
    }
}
