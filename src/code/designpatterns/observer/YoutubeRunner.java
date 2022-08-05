package code.designpatterns.observer;

//https://www.youtube.com/watch?v=98DiwRp-KZk
public class YoutubeRunner {

    public static void main(String args[]) {
        Channel channel = new Channel("My channel");

        Subscriber sub1 = new Subscriber("a");
        Subscriber sub2 = new Subscriber("b");
        Subscriber sub3 = new Subscriber("c");
        Subscriber sub4 = new Subscriber("d");

        channel.subscribe(sub1);
        channel.subscribe(sub2);
        channel.subscribe(sub3);
        channel.subscribe(sub4);

        channel.uploadVideo("MyfirstVideo");
    }


}
