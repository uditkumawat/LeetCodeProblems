package code.facebook;

public class MaximalSquare {

    public int getMaxValue(int matrix[][]){

        int rows = matrix.length;
        int cols = matrix[0].length;
        int maxValue = 1;

        int dp[][] = new int[rows+1][cols+1];

        for(int i=1;i<=rows;i++){
            for(int j=1;j<=cols;j++){
                if(matrix[i-1][j-1]==1){
                    dp[i][j] = Math.min(dp[i-1][j-1],
                            Math.min(dp[i-1][j],dp[i][j-1]))+1;
                    maxValue = Math.max(maxValue,dp[i][j]);
                }
            }
        }

        return maxValue*maxValue;
    }
}
