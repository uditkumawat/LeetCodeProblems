package code.leetcodeTopInterviewQuestions;

//https://www.youtube.com/watch?v=UZ5QK-UV8MI
public class CoinChangeII {


    public int change(int amount,int coins[]){
        return helper(amount,coins,0);
    }

    public int helper(int amount,int coins[],int index){
        if(amount==0){
            return 1;
        }
        if(amount<0 || index==coins.length){
            return 0;
        }

        int result = 0;

        for(int i=index;i<coins.length;i++){
            if(amount>=coins[i]){
                result+=helper(amount-coins[i],coins,i);
            }
        }

        return result;
    }


    public int changeDP(int amount, int[] coins) {
        int[] dp = new int[amount + 1];
        dp[0] = 1;
        for (int coin : coins) {
            for (int i = 1; i <= amount; i++) {
                if (i >= coin) dp[i] += dp[i - coin];
            }
        }
        return dp[amount];
    }
}
