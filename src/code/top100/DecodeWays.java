package code.top100;

/**
 * Time Complexity: O(N)O(N), where NN is length of the string. We iterate the length of dp array which is N+1N+1.
 *
 * Space Complexity: O(N)O(N). The length of the DP array.
 */
public class DecodeWays {

    public int numDecodings(String s) {

        int dp[] = new int[s.length()+1];
        dp[0] = 1;

        dp[1] = s.charAt(0)=='0'?0:1;

        for(int i=2;i<dp.length;i++){

            if(s.charAt(i-1)!='0'){
                dp[i] = dp[i-1];
            }

            int twoDigits = Integer.parseInt(s.substring(i-2,i));
            if(twoDigits>=10 && twoDigits<=26){
                dp[i]+=dp[i-2];
            }
        }

        return dp[s.length()];
    }


    public int numDecodingsBEst(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        int n = s.length();
        int[] dp = new int[n + 1];
        dp[0] = 1;
        dp[1] = s.charAt(0) != '0' ? 1 : 0;
        for (int i = 2; i <= n; i++) {
            int first = Integer.valueOf(s.substring(i - 1, i));
            int second = Integer.valueOf(s.substring(i - 2, i));
            if (first >= 1) {
                dp[i] += dp[i-1];
            }
            if (second >= 10 && second <= 26) {
                dp[i] += dp[i-2];
            }
        }
        return dp[n];
    }
}
