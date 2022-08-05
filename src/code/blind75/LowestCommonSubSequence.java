package code.blind75;

//https://leetcode.com/problems/longest-common-subsequence/submissions/
//TC - O(m * n)
//SC - O(m * n)
//https://www.youtube.com/watch?v=I3Nc9ZWfgZE
public class LowestCommonSubSequence {

    public int longestCommonSubsequence(String text1, String text2) {

        int m = text1.length();
        int n = text2.length();

        int dp[][] = new int[m+1][n+1];

        for(int i=1;i<=m;i++){
            for(int j=1;j<=n;j++){

                if(text1.charAt(i-1)==text2.charAt(j-1)){
                    dp[i][j] = dp[i-1][j-1]+1;
                }
                else{
                    dp[i][j] = Math.max(dp[i-1][j],dp[i][j-1]);
                }
            }
        }

        return dp[m][n];
    }
}
