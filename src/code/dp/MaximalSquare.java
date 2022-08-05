package code.dp;

public class MaximalSquare {

    public int maximalSquare(char[][] matrix) {

        int rows = matrix.length;
        int cols = matrix[0].length;

        if(matrix==null || matrix[0].length==0){
            return 0;
        }

        int dp[][] = new int[rows][cols];

        for(int i=0;i<rows;i++){
            for(int j=0;j<cols;j++){
                dp[i][j] = matrix[i][j]=='1'?1:0;
            }
        }

        int max = 0;

        for(int i=1;i<rows;i++){
            for(int j=1;j<cols;j++){

                if(dp[i][j]==1){
                    dp[i][j] = dp[i][j] + Math.min(dp[i-1][j-1],Math.min(dp[i-1][j],dp[i][j-1]));
                }
                max = Math.max(max,dp[i][j]);
            }
        }

        return max*max;
    }
}
