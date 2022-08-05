package code.blind75;

import java.util.Arrays;

//https://www.youtube.com/watch?v=wTi5Mhy9HWQ
//https://leetcode.com/problems/coin-change/
//TC - O(amount * coins count)
//SC - O(amount)
public class CoinChange {

    public int coinChange(int[] coins, int amount) {

        int dp[] = new int[amount+1];

        Arrays.fill(dp,Integer.MAX_VALUE);
        dp[0] = 0;

        for(int amt=1;amt<=amount;amt++){
            for(int coin:coins){
                if(amt-coin>=0 && dp[amt-coin]!=Integer.MAX_VALUE){
                    dp[amt] = Math.min(dp[amt],dp[amt-coin]+1);
                }
            }
        }

        return dp[amount]!=Integer.MAX_VALUE?dp[amount]:-1;
    }
}
