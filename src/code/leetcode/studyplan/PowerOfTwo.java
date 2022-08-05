package code.leetcode.studyplan;

//https://leetcode.com/problems/power-of-two/
//TC_O(1)
public class PowerOfTwo {

    public boolean isPowerOfTwo(int n) {
        if(n==0){
            return false;
        }
        long x = (long)n;
        return ((x & (x-1))==0);
    }
}
