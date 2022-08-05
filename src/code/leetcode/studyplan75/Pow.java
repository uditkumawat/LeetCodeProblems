package code.leetcode.studyplan75;

//https://leetcode.com/problems/powx-n/solution/
//TC - O(logn)
//SC - O(logn)
public class Pow {

    public double myPow(double x, int n) {

        if(n<0){
            x = 1/x;
            n = -1*n;
        }
        if(n==0){
            return 1;
        }

        if(n==1){
            return x;
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
