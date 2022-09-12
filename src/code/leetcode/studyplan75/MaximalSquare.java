package code.leetcode.studyplan75;

//https://leetcode.com/problems/maximal-square/submissions/
//TC - O(r*c)
//SC - O(r*c)
public class MaximalSquare {

    public int maximalSquare(char[][] matrix) {

        if(matrix==null || matrix.length==0){
            return 0;
        }

        int rows = matrix.length;
        int cols = matrix[0].length;

        int dp[][] = new int[rows+1][cols+1];
        int max = 0;

        for(int i=1;i<=rows;i++){
            for(int j=1;j<=cols;j++){

                if(matrix[i-1][j-1]=='1'){

                    dp[i][j] = Math.min(dp[i-1][j],Math.min(dp[i-1][j-1],dp[i][j-1]))+1;
                    max = Math.max(max,dp[i][j]);
                }
            }
        }

        return max*max;
    }
}
