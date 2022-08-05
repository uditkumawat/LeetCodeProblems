package code.june.challenge;

//https://www.youtube.com/watch?v=hAyme0s2DOY&t=15s
//TC - O(m*n)
//SC - O(m*n)
public class RangeSumQuery2DImmutable {

    int dp[][];
    public RangeSumQuery2DImmutable(int[][] matrix) {
        int rows = matrix.length;
        int cols = matrix[0].length;
        dp = new int[rows+1][cols+1];

        for(int i=1;i<=rows;i++){
            for(int j=1;j<=cols;j++){
                dp[i][j] = matrix[i-1][j-1]+dp[i-1][j]+dp[i][j-1]-dp[i-1][j-1];
            }
        }
    }

    public int sumRegion(int row1, int col1, int row2, int col2) {

        return dp[row2+1][col2+1]-dp[row1][col2+1]-dp[row2+1][col1]+dp[row1][col1];
    }
}
