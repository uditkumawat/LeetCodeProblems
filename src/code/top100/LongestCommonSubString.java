package code.top100;

public class LongestCommonSubString {

    public static void main(String args[]){

        String s1 = "ABCDGH";
        String s2 = "ACDGHR";

        System.out.println(maxLength(s1,s2));

        System.out.println(findLCS(s1,s2));

    }

    public static int maxLength(String s1,String s2){

        int s1len = s1.length();
        int s2len = s2.length();
        int dp[][] = new int[s1len+1][s2len+1];

        int maxLength=0;

        for(int i=1;i<=s1len;i++){
            for(int j=1;j<=s2len;j++){
                if(s1.charAt(i-1)==s2.charAt(j-1)){
                    dp[i][j] = 1+dp[i-1][j-1];
                }
                else{
                    dp[i][j] = 0;
                }

                maxLength = Math.max(maxLength,dp[i][j]);
            }
        }

        return maxLength;
    }

    public static String findLCS(String s1,String s2){

        int s1len = s1.length();
        int s2len = s2.length();
        String dp[][] = new String[s1len+1][s2len+1];
        String lcsString = "";

        for(int i=0;i<=s1len;i++){
            for(int j=0;j<=s2len;j++){
                if(i==0 || j==0) {
                    dp[i][j] = "";
                }
                else if(s1.charAt(i-1)==s2.charAt(j-1)){
                    dp[i][j] = dp[i-1][j-1]+s1.charAt(i-1);
                    if(dp[i][j].length()>lcsString.length()){
                        lcsString = dp[i][j];
                    }
                }
                else{
                    dp[i][j] = "";
                }
            }
        }

        return lcsString;
    }



}
