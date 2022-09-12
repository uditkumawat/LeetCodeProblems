package code.designpatterns.abstractfactory;

public class NotificationTypeSystemFactory {

    public static NotificationTypeSystem getNotificationTypeSystem(String type){
        if("EMAIL".equalsIgnoreCase(type)){
            return new EmailNotification();
        }
        else if("MAIL".equalsIgnoreCase(type)){
            return new MailNotification();
        }
        else if("MSG".equalsIgnoreCase(type)){
            return new MsgNotification();
        }
        else{
            return new NullNotification();
        }
    }
}
