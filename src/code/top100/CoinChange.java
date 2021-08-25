package code.top100;

import java.util.Arrays;

/**
 * Time complexity : O(S*n)O(S∗n). On each step the algorithm finds the next F(i)F(i) in nn iterations, where 1\leq i \leq S1≤i≤S. Therefore in total the iterations are S*nS∗n.
 * Space complexity : O(S)O(S). We use extra space for the memoization table.
 */
public class CoinChange {

    public static int coinChange(int coins[],int amount){
        return recursionHelper(coins,amount);
    }

    public static int coinChangedp(int coins[],int amount){
        int max = amount+1;
        int dp[] = new int[max];
        Arrays.fill(dp,max);
        dp[0] = 0;
        for(int i=1;i<=amount;i++){
            for(int j=0;j<coins.length;j++){
                if(coins[j]<=i){
                    dp[i] = Math.min(dp[i],dp[i-coins[j]]+1);
                }
            }
        }

        return dp[amount]>amount?-1:dp[amount];
    }
    public static int recursionHelper(int coins[],int remain){
        if(remain<0){
            return -1;
        }
        if(remain==0){
            return 0;
        }

        int minCount = Integer.MAX_VALUE;

        for(int coin : coins){
            int count = recursionHelper(coins,remain-coin);
            if(count == -1){
                continue;
            }
            minCount = Math.min(minCount,count+1);
        }

        return minCount==Integer.MAX_VALUE?-1:minCount;
    }
}
