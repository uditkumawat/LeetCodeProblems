package code.bloomberg;

//https://leetcode.com/problems/powx-n/submissions/
//TC - O(logn)
//SC - O(logn)
public class Pow {

    public double myPow(double x, int n) {

        long N = n;

        if(N<0){
            x = 1/x;
            N = -1*N;
        }

        return pow(x,N);
    }

    public double pow(double x,long n){
        if(n==0){
            return 1.0;
        }
        double temp = pow(x,n/2);
        if(n%2==0){
            return temp*temp;
        }
        else{
            return x*temp*temp;
        }
    }
}
