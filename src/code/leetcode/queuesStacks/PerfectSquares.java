package code.leetcode.queuesStacks;

import java.util.Arrays;

//https://leetcode.com/problems/perfect-squares/solution/
//https://www.youtube.com/watch?v=o2IBfabt8qM
//https://www.youtube.com/watch?v=1xfx6M_GqFk
//TC - O(N * N^1/2) -> n into square root of n
public class PerfectSquares {

    public int numSquares(int n) {

        if(n<=3){
            return n;
        }

        int dp[] = new int[n+1];
        Arrays.fill(dp,n);
        dp[0] = 0;
        dp[1] = 1;
        dp[2] = 2;
        dp[3] = 3;

        for(int i=4;i<=n;i++){
            for(int j=1;j*j<=i;j++){
                dp[i] = Math.min(dp[i],dp[i-j*j]+1);
            }
        }

        return dp[n];
    }

}
