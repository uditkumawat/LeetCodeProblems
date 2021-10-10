package code.top100;

//https://www.youtube.com/watch?v=AuYujVj646Q&list=PLEJXowNB4kPxBwaXtRO1qFLpCzF75DYrS&index=29
public class MinEditDistance {

    public static void main(String args[]){

        String s1 = "sunday";
        String s2 = "saturday";

        System.out.println(minOperations(s1,s2));
    }

    public static int minOperations(String s1,String s2){

        int m = s1.length();
        int n = s2.length();

        int dp[][] = new int[m+1][n+1];

        for(int i=0;i<=m;i++){
            for(int j=0;j<=n;j++){

                //when s1 is null, so we need insert operations for each character
                if (i == 0) {
                    dp[i][j] = j;
                }

                //when s2 is null, so we need insert operations for each character
                else if (j == 0) {
                    dp[i][j] = i;
                }

                //if characters are same, no operations needed
                else if(s1.charAt(i-1)==s2.charAt(j-1)){
                    dp[i][j] = dp[i-1][j-1];
                }
                //if last character is different,consider all possibilities and find the min
                else if(s1.charAt(i-1)!=s2.charAt(j-1)){
                    dp[i][j] = 1+Math.min(dp[i-1][j-1],Math.min(dp[i-1][j],dp[i][j-1]));
                }
            }
        }

        return dp[m][n];
    }
}
