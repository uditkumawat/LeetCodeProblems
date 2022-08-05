package code.leetcode.studyplan75;

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
