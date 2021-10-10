package code.top100;

public class ClimbStairs {

    public static void main(String args[]){

        int n =4;
        int first =1;
        int second = 2;
        int third=0;
        for(int i=3;i<=n;i++){
            third = second+first;
            first =second;
            second = third;
        }
        System.out.println(second);
    }
}
