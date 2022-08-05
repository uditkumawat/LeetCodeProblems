package code.may.challenge;

import java.util.Arrays;

//https://leetcode.com/problems/coin-change/
//https://www.youtube.com/watch?v=wTi5Mhy9HWQ
//TC - O(amount*(number of coins))
public class CoinChange {

    public int coinChange(int[] coins, int amount) {

        int dp[] = new int[amount+1];

        Arrays.fill(dp,Integer.MAX_VALUE);

        dp[0] = 0;

        for(int i=1;i<dp.length;i++){
            for(int coin:coins){
                if(i-coin>=0 && dp[i-coin]!=Integer.MAX_VALUE){
                    dp[i] = Math.min(dp[i],dp[i-coin]+1);
                }
            }
        }

        return dp[amount]!=Integer.MAX_VALUE?dp[amount]:-1;
    }
}
