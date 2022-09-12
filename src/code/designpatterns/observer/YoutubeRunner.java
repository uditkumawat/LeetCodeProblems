package code.designpatterns.observer;

//https://www.youtube.com/watch?v=Ep9_Zcgst3U&list=PL6W8uoQQ2c61X_9e6Net0WdYZidm7zooW&index=3
public class YoutubeRunner {

    public static void main(String args[]) {
        Channel channel = new Channel("My channel");

        Subscriber sub1 = new Subscriber("a");
        Subscriber sub2 = new Subscriber("b");
        Subscriber sub3 = new Subscriber("c");
        Subscriber sub4 = new Subscriber("d");

        channel.add(sub1);
        channel.add(sub2);
        channel.add(sub3);
        channel.add(sub4);

        channel.uploadVideo("MyfirstVideo");
    }


}
