package code.leetcode.studyplan75;

//https://leetcode.com/problems/number-of-1-bits/submissions/

/**
 * The run time depends on the number of bits in nn. Because nn in this piece of code is a 32-bit integer, the time complexity is O(1)O(1).
 *
 * The space complexity is O(1)O(1), since no additional space is allocated.
 */
public class NumberOf1Bits {

    public int hammingWeight(int n) {

        int ones = 0;

        while(n!=0){
            if((n&1)==1){
                ones++;
            }
            n>>>=1;
        }
        return ones;
    }
}
