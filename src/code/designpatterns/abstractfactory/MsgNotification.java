package code.designpatterns.abstractfactory;

public class MsgNotification implements NotificationTypeSystem{
    @Override
    public void send() {
        System.out.println("Msg sent");
    }
}
