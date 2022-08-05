package code.top100;

import java.util.Arrays;

//https://www.youtube.com/watch?v=ZI17bgz07EE
/**
 * Time complexity : O(S*n)O(S∗n). On each step the algorithm finds the next F(i)F(i) in nn iterations, where 1\leq i \leq S1≤i≤S. Therefore in total the iterations are S*nS∗n.
 * Space complexity : O(S)O(S). We use extra space for the memoization table.
 */
public class CoinChange {

    public static int coinChange(int coins[],int amount){
        return recursionHelper(coins,amount);
    }

    public static int coinChangeCorrect(int[] coins, int amount) {

        if(amount==0){
            return 0;
        }

        if((coins==null || coins.length==0) && amount!=0){
            return -1;
        }

        int n = coins.length;

        int dp[][] = new int[n+1][amount+1];

        dp[0][0] = 0;

        //if number of coins are 0 in count, then for amount we need infinite number of coins
        for(int i=1;i<=amount;i++){
            dp[0][i] = Integer.MAX_VALUE;
        }

        //sum=0 , not selecting any coin, so number of coins selecting will be 0
        for(int i=1;i<=n;i++){
            dp[i][0] = 0;
        }

        for(int i=1;i<=n;i++){
            for(int j=1;j<=amount;j++){

                //coin is bigger than currSum, then we will exclude that
                if(coins[i-1]>j){
                    dp[i][j] = dp[i-1][j];
                }
                else{
                    if(j-coins[i-1]>=0){
                        dp[i][j] = Math.min(1+dp[i][j-coins[i-1]],dp[i-1][j]);
                    }
                    else{
                        dp[i][j] = dp[i-1][j];
                    }
                }
            }
        }
        return dp[n][amount]!=Integer.MAX_VALUE?dp[n][amount]:-1;
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
