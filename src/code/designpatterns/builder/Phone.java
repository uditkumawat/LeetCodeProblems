package code.designpatterns.builder;

public class Phone {

    private String name;
    private String company;
    private String os;
    private int battery;
    private int screensize;

    @Override
    public String toString() {
        return "Phone{" +
                "name='" + name + '\'' +
                ", company='" + company + '\'' +
                ", os='" + os + '\'' +
                ", battery=" + battery +
                ", screensize=" + screensize +
                '}';
    }

    Phone(String name, String company,String os,int battery,int screensize){
        this.os = os;
        this.battery = battery;
        this.screensize = screensize;
        this.name = name;
        this.company = company;
    }
}
