package code.designpatterns.builder;

public class PhoneBuilder {

    private String name;
    private String company;
    private String os;
    private int battery;
    private int screensize;

    public PhoneBuilder setName(String name){
        this.name = name;
        return this;
    }

    public PhoneBuilder setCompany(String company){
        this.company = company;
        return this;
    }

    public PhoneBuilder setOs(String os){
        this.os = os;
        return this;
    }

    public PhoneBuilder setScreenSize(int screenSize){
        this.screensize = screenSize;
        return this;
    }

    public Phone getPhone(){
        return new Phone(name,company,os,battery,screensize);
    }
}
