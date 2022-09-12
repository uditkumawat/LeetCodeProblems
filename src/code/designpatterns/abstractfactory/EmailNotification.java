package code.designpatterns.abstractfactory;

public class EmailNotification implements NotificationTypeSystem{

    @Override
    public void send() {
        System.out.println("Email sent");
    }
}
