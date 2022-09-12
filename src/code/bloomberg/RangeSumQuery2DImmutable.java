package code.bloomberg;

//TC - O(m*n)
//SC - O(m*n)
//https://leetcode.com/problems/range-sum-query-2d-immutable/submissions/
public class RangeSumQuery2DImmutable {

    int dp[][];
    public RangeSumQuery2DImmutable(int[][] matrix) {
        if(matrix.length==0 || matrix[0].length==0){
            return;
        }

        dp = new int[matrix.length+1][matrix[0].length+1];

        for(int r=1;r<dp.length;r++){
            for(int c=1;c<dp[0].length;c++){

                dp[r][c] = dp[r-1][c]+dp[r][c-1]+matrix[r-1][c-1]-dp[r-1][c-1];
            }
        }
    }

    public int sumRegion(int row1, int col1, int row2, int col2) {

        return dp[row2+1][col2+1]-dp[row1][col2+1] -dp[row2+1][col1]+dp[row1][col1];
    }
}
