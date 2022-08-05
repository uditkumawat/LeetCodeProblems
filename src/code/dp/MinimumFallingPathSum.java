package code.dp;

//https://leetcode.com/problems/minimum-falling-path-sum//

public class MinimumFallingPathSum {

    public int minFallingPathSum(int[][] matrix) {
        int rows = matrix.length;
        int cols = matrix[0].length;

        int dp[][] = new int[rows][cols];

        for(int i=0;i<matrix[0].length;i++){
            dp[0][i] = matrix[0][i];
        }

        for(int i=1;i<matrix.length;i++){
            for(int j=0;j<matrix[i].length;j++){
                if(j==0){
                    dp[i][j] = matrix[i][j]+Math.min(dp[i-1][j],dp[i-1][j+1]);
                }
                else if(j==matrix[0].length-1){
                    dp[i][j] = matrix[i][j]+Math.min(dp[i-1][j-1],dp[i-1][j]);
                }
                else{
                    dp[i][j] = matrix[i][j]+Math.min(dp[i-1][j],Math.min(dp[i-1][j-1],dp[i-1][j+1]));
                }
            }
        }

        int min = Integer.MAX_VALUE;

        for(int i=0;i<dp[0].length;i++){
            min = Math.min(min,dp[dp.length-1][i]);
        }

        return min;
    }
}
