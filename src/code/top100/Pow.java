package code.top100;

//TC - O(logn)
public class Pow {

    public static void main(String args[]){

        System.out.println(myPow(2.1,3));

    }

    public static double myPow(double x, int n) {

        long N = n;
        if(N<0){
            x = 1/x;
            N = -N;
        }

        return pow(x,N);
    }

    public static double pow(double x,long n){
        if(n==0){
            return 1.0;
        }

        double half = pow(x,n/2);
        if(n%2==0){
            return half*half;
        }
        else{
            return half*half*x;
        }
    }
}
