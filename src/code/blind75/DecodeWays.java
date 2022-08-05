package code.blind75;

//https://leetcode.com/problems/decode-ways/
//TC - O(N)
//SC - O(N)
public class DecodeWays {

    public int numDecodings(String s) {

        int dp[] = new int[s.length()+1];

        dp[0] = 1;
        dp[1] = s.charAt(0)=='0'?0:1;

        for(int i=2;i<=s.length();i++){

            if(s.charAt(i-1)!='0'){
                dp[i] = dp[i-1];
            }

            int num = Integer.parseInt(s.substring(i-2,i));
            if(num>=10 && num<=26){
                dp[i]+=dp[i-2];
            }
        }

        return dp[s.length()];
    }
}
