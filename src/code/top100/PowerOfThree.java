package code.top100;

/**
 * Time complexity : O(\log_b(n))O(log
 * b
 * ​
 *  (n)). In our case that is O(\log_3n)O(log
 * 3
 * ​
 *  n). The number of divisions is given by that logarithm.
 *
 * Space complexity : O(1)O(1). We are not using any additional memory.
 */
public class PowerOfThree {

    public boolean isPowerOfThree(int n) {
        if(n<1){
            return false;
        }

        while(n%3==0){
            n = n/3;
        }

        return n==1;
    }
}
