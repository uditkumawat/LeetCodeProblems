package code.facebook;

import code.microsoft.WaterBottles;

public class TribonacciNumber {

    public static void main(String args[]){

        TribonacciNumber obj = new TribonacciNumber();

        System.out.println(obj.tribonacci(25));
    }
    public int tribonacci(int n) {

        if(n<3){
            return n==0?0:1;
        }

        int first = 0;
        int second = 1;
        int third = 1;

        int fourth=0;

        for(int i=3;i<=n;i++){
            fourth = first+second+third;
            first = second;
            second = third;
            third = fourth;
        }

        return fourth;
    }
}
