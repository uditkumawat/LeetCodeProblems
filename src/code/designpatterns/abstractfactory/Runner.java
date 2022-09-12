package code.designpatterns.abstractfactory;

//https://www.youtube.com/watch?v=hWVfRwgfdGg
//https://github.com/TechPrimers/creational-design-patterns-example/tree/master/src/main/java/com/techprimers/designpatterns/abstractfactory
public class Runner {

    public static void main(String args[]){

        NotificationTypeSystem notificationTypeSystem = NotificationTypeSystemFactory.getNotificationTypeSystem("EMAIL");
        notificationTypeSystem.send();
    }
}
