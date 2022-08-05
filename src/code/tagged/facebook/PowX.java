package code.tagged.facebook;

/**
 * Time complexity : O(\log n)O(logn). Each time we apply the formula (x ^ n) ^ 2 = x ^ {2 * n}(x
 * n
 *  )
 * 2
 *  =x
 * 2∗n
 *  , nn is reduced by half. Thus we need at most O(\log n)O(logn) computations to get the result.
 *
 * Space complexity : O(\log n)O(logn). For each computation, we need to store the result of x ^ {n / 2}x
 * n/2
 *  . We need to do the computation for O(\log n)O(logn) times, so the space complexity is O(\log n)O(logn).
 */
//https://leetcode.com/problems/powx-n/solution/
public class PowX {

    public double myPow(double x, int n) {
        if(n==0){
            return 1;
        }

        if(n<0){
            x = 1/x;
            n = -1*n;
        }

        double temp = myPow(x,n/2);
        if(n%2==1){
            return x*temp*temp;
        }
        else{
            return temp*temp;
        }
    }
}
