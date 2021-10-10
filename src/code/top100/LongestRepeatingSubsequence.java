package code.top100;

//https://www.youtube.com/watch?v=ZqG89Z-dKpI&list=PLEJXowNB4kPxBwaXtRO1qFLpCzF75DYrS&index=22
//TC - O(n*n)
//SC-O(n*n)
public class LongestRepeatingSubsequence {

    public static void main(String args[]){

        String s1 = "AABB";

        String subsequence = findCommonRepeatingSubsequence(s1);

        System.out.println(subsequence+" "+ subsequence.length());
    }

    public static String findCommonRepeatingSubsequence(String s1){

        int s1len = s1.length();
        String dp[][] = new String[s1len+1][s1len+1];

        for(int i=0;i<=s1len;i++){
            for(int j=0;j<=s1len;j++){
                if(i==0 || j==0){
                    dp[i][j] = "";
                }
                else if(s1.charAt(i-1)==s1.charAt(j-1) && i-1!=j-1){
                    dp[i][j] = dp[i-1][j-1]+s1.charAt(i-1);
                }
                else{
                    dp[i][j] = dp[i-1][j].length()>dp[i][j-1].length()?dp[i-1][j]:dp[i][j-1];
                }
            }
        }

        return dp[s1len][s1len];
    }
}
