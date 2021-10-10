package code.top100;

//https://www.youtube.com/watch?v=Ztt-VtNyqL8&list=PLEJXowNB4kPxQIN2dCUAnQ_92HIziG4x6&index=49
public class RightMostBit {

    public static void main(String args[]){
        int n = 10;
        int mask = 1;
        int counter=0;

        while(n!=0){
            if((mask & n)==1){
                System.out.println(counter);
                break;
            }
            n=n>>1;
            counter++;
        }

    }
}
