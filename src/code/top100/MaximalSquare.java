package code.top100;

//TC - O(m*n)
//SC - O(m*n)
//
public class MaximalSquare {

    public int maximalSquare(char[][] matrix) {

        if(matrix==null || matrix.length==0){
            return 0;
        }

        int rows = matrix.length;
        int cols = matrix[0].length;
        int dp[][] = new int[rows+1][cols+1];

        int maxSize = 0;
        for(int i=1;i<=rows;i++){
            for(int j=1;j<=cols;j++){
                if(matrix[i-1][j-1]==0){
                    dp[i][j] = 0;
                }
                else {
                    dp[i][j] = 1 + Math.min(dp[i - 1][j - 1], Math.min(dp[i - 1][j], dp[i][j - 1]));
                    maxSize = Math.max(maxSize, dp[i][j]);
                }
            }
        }

        return maxSize;
    }
}
