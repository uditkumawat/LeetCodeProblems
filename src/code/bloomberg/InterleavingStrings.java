package code.bloomberg;

//https://www.youtube.com/watch?v=U49f4WpAhV4
//TC - O(m*n)
//SC - O(m*n)
public class InterleavingStrings {

    public boolean isInterleaving(String s1,String s2,String s3){

        int m = s1.length();
        int n = s2.length();

        if(m+n!=s3.length()){
            return false;
        }

        boolean dp[][] = new boolean[m+1][n+1];

        dp[0][0] = true;

        //fill first column
        for(int i=1;i<=m;i++){
            if(s1.charAt(i-1)==s3.charAt(i-1)){
                dp[i][0] = dp[i-1][0];
            }
            else{
                dp[i][0] = false;
            }
        }

        //fill first row
        for(int i=1;i<=n;i++){
            if(s2.charAt(i-1)==s3.charAt(i-1)){
                dp[0][i] = dp[0][i-1];
            }
            else{
                dp[0][i] = false;
            }
        }

        for(int i=1;i<=m;i++){
            for(int j=1;j<=n;j++){


                if(s3.charAt(i+j-1)==s1.charAt(i-1)){
                    dp[i][j] = dp[i-1][j];
                }

                //same character can be present in both
                if(s3.charAt(i+j-1)==s2.charAt(j-1)){
                    dp[i][j] = dp[i][j] || dp[i][j-1];
                }
            }
        }

        return dp[m][n];
    }
}
