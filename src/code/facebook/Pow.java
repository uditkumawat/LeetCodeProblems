package code.facebook;


//https://leetcode.com/problems/powx-n/
//TC - O(logn)
public class Pow {

    public static void main(String args[]){

        double x = 2.00000;
        int n = -2;

        Pow obj = new Pow();

        System.out.println(obj.myPow(x,n));

    }
    public double myPow(double x, int n) {
        if(n==0){
            return 1.0;
        }

        if(n<0){
            n = n*-1;
            return myPow(1/x,n);
        }

        double temp = myPow(x,n/2);
        if(n%2==0){
            return temp*temp;
        }
        else{
            return x*temp*temp;
        }
    }
}
