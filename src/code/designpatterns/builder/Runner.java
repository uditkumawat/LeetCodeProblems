package code.designpatterns.builder;

//https://www.youtube.com/watch?v=k4EkJgY9P4c
public class Runner {

    public static void main(String args[]){

        Phone phone = new PhoneBuilder().setName("Android").setCompany("OnePlus").setOs("Ios").getPhone();

        System.out.println(phone);
    }
}
