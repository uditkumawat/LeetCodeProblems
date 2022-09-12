package code.designpatterns.observer;

import java.util.HashSet;
import java.util.Set;

public class Channel implements Observable {

    private String channelName;
    private Set<Observer> observers = new HashSet<>();
    private String title;

    public Channel(String channelName){
        this.channelName = channelName;
    }

    @Override
    public void add(Observer observer){
        observers.add(observer);
    }

    @Override
    public void remove(Observer observer){
        observers.remove(observer);
    }

    @Override
    public void notifyAllObservers(){
        for(Observer observer:observers){
            observer.update();
        }
    }

    public void uploadVideo(String title){
        this.title = title;
        System.out.println("Video uploaded");
        notifyAllObservers();
    }
}
