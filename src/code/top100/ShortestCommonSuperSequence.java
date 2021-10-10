package code.top100;

//https://www.youtube.com/watch?v=pHXntFeu6f8&list=PLEJXowNB4kPxBwaXtRO1qFLpCzF75DYrS&index=20
public class ShortestCommonSuperSequence {

    public static void main(String args[]){

        String s1 = "abac";
        String s2 = "cab";

       String lcs = findCommonSubsequence(s1,s2);

       int p1=0;
       int p2=0;

       String ans="";
       for(char c:lcs.toCharArray()){

           while(s1.charAt(p1)!=c){
               ans+=s1.charAt(p1++);
           }

           while(s2.charAt(p2)!=c){
               ans+=s2.charAt(p2++);
           }

           ans+=c;
           ++p1;
           ++p2;
       }

       ans+=s1.substring(p1)+s2.substring(p2);

       System.out.println(ans);
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
