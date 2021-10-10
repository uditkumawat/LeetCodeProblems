package code.top100;

//https://www.youtube.com/watch?v=7SHV_QfVROE
//TC - O(l1*l2)
//SC - O(l1*l2)
//https://www.geeksforgeeks.org/wildcard-pattern-matching/
public class WildcardMatching {

    public static void main(String args[]){

//        String str = "baaabab";
//        String pattern = "ba*****ab";

        String str = "baaabab";
        String pattern = "a*ab";

        System.out.println(isMatching(str.toCharArray(),pattern.toCharArray()));
    }

    static boolean isMatching(char str[],char pattern[]){

        int l1 = str.length;
        int l2 = pattern.length;
        boolean dp[][] = new boolean[l1+1][l2+1];

        dp[0][0] = true;

        //pattern is empty and string is not null, so not matching
        for(int i=1;i<=l1;i++){
            dp[i][0] = false;
        }

        //string is null and pattern is not null, so not matching
        //but special case is of '*', it can be 0 or more characters...we need to check for last character before that asterik
        for(int i=1;i<=l2;i++){
            dp[0][i] = false;
            if(pattern[i-1]=='*'){
                dp[0][i] = dp[0][i-1];
            }
        }

        for(int i=1;i<=l1;i++){
            for(int j=1;j<=l2;j++){

                if(str[i-1]==pattern[j-1] || pattern[j-1]=='?'){
                    dp[i][j] = dp[i-1][j-1];                    // if characters match or either patterh in ?
                }
                else if(pattern[j-1]=='*'){
                    dp[i][j] = dp[i-1][j] || dp[i][j-1];         // include both cases...either include * or remove
                }
                else{
                    dp[i][j] = false;                           // is characters are not matching
                }
            }
        }

        return dp[l1][l2];
    }
}
