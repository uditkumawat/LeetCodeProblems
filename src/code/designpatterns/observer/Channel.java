package code.designpatterns.observer;

import java.util.HashSet;
import java.util.Set;

public class Channel {

    private String channelName;
    private Set<Subscriber> subs = new HashSet<>();
    private String title;

    public Channel(String channelName){
        this.channelName = channelName;
    }

    public void subscribe(Subscriber subscriber){
        subs.add(subscriber);
    }

    public void unSubscribe(Subscriber subscriber){
        subs.remove(subscriber);
    }
    public void notifyAllSubs(){
        for(Subscriber subscriber:subs){
            subscriber.update();
        }
    }

    public void uploadVideo(String title){
        this.title = title;
        System.out.println("Video uploaded");
        notifyAllSubs();
    }
}
