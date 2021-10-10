package code.top100;

//TC  - O(N*W)
//https://www.youtube.com/watch?v=WNkqbqyvR_0&list=PLEJXowNB4kPxBwaXtRO1qFLpCzF75DYrS&index=6
public class Knapsack {

    public static void main(String args[]){

        int wt[] = {1,2,3};
        int profit[]={5,6,7};
        int W = 3;
        int n = 3;

        System.out.println(knapsack(wt,profit,W,n));
    }

    /*
    if(w==0||n==0){
        return 0;
    }
    if(wt[n-1]>W){
        functionCall(wt,profit,W,n-1);
    }
    else{
        Math.max(functionCall(wt,profit,W,n-1), profit[n-1]+ functionCall(wt,profit,W-wt[n-1],n-1))
    }
     */
    public static int knapsack(int wt[],int profit[],int W,int n){

        int dp[][] = new int[n+1][W+1];

        for(int i=0;i<=n;i++){
            for(int j=0;j<=W;j++){

                if(i==0 || j==0){
                    dp[i][j] = 0;
                }
                else if(wt[i-1]>j){   //wt is more than knapsack size, so skipping it and taking profit when we don't include this element
                    dp[i][j] = dp[i-1][j];
                }
                else{
                    dp[i][j] = Math.max(dp[i-1][j],profit[i-1]+dp[i-1][j-wt[i-1]]);
                }
            }
        }
        return dp[n][W];
    }
}
