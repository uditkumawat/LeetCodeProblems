package code.top100;

/**
 * The solution is straightforward:
 *
 * Power of two has just one 1-bit.
 *
 * x & (x - 1) sets this 1-bit to zero, and hence one has to verify if the result is zero x & (x - 1) == 0.
 */
public class PowerOfTwo {

    public boolean isPowerOfTwo(int n) {
        if(n<1){
            return false;
        }

        return (n&(n-1))==0;
    }
}
