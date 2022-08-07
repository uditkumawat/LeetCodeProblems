package code.enumclass;

//https://www.youtube.com/watch?v=ThN8IXr0n_k&list=PLsyeobzWxl7pqDkHDPUoy75HLb_JLnZIy&index=3
public class Runner {

    enum Mobile{
        APPLE(80),SAMSUNG(10),HTC;

        int price;

        Mobile(){
            this.price = 50;
            System.out.println("Default constructor called");
        }

        Mobile(int price){
            this.price = price;
            System.out.println("Parameterized constructor called");
        }

        public int getPrice(){
            return price;
        }
    }

    public static void main(String args[]){

        //System.out.println(Mobile.HTC);
        System.out.println(Mobile.SAMSUNG.getPrice());

    }
}
