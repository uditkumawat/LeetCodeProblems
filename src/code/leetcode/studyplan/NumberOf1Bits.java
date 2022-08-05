package code.leetcode.studyplan;

//https://leetcode.com/problems/number-of-1-bits/submissions/
//TC-O(1)
public class NumberOf1Bits {

    public int hammingWeight(int n) {

        int count = 0;

        while(n!=0){
            if((n&1)==1){
                count++;
            }
            n>>>=1;   /// >>> is used for unsigned value
        }

        return count;
    }
}
