package code.top100;

public class LongestCommonSubSequence {

    public static void main(String args[]){

        String s1 = "ABCDGH";
        String s2 = "AEDFHR";

        String subsequence = findCommonSubsequence(s1,s2);

        System.out.println(subsequence+" "+ subsequence.length());
    }

    public static String findCommonSubsequence(String s1,String s2){

        int s1len = s1.length();
        int s2len = s2.length();
        String dp[][] = new String[s1len+1][s2len+1];

        for(int i=0;i<=s1len;i++){
            for(int j=0;j<=s2len;j++){
                if(i==0 || j==0){
                    dp[i][j] = "";
                }
                else if(s1.charAt(i-1)==s2.charAt(j-1)){
                    dp[i][j] = dp[i-1][j-1]+s1.charAt(i-1);
                }
                else{
                    dp[i][j] = dp[i-1][j].length()>dp[i][j-1].length()?dp[i-1][j]:dp[i][j-1];
                }
            }
        }

        return dp[s1len][s2len];
    }
}
