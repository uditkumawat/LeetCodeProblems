package code.designpatterns.abstractfactory;

public class MailNotification implements NotificationTypeSystem{
    @Override
    public void send() {
        System.out.println("Mail sent");
    }
}
