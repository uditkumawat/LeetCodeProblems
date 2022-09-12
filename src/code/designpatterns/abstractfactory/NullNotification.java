package code.designpatterns.abstractfactory;

public class NullNotification implements NotificationTypeSystem{
    @Override
    public void send() {
        System.out.println("Invalid Notification system");
    }
}
