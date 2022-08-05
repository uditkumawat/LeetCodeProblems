package code.dp;

import java.util.HashMap;
import java.util.Map;

public class DecodeWays {

    Map<Integer,Integer> map;
    public int numDecodings(String s) {

        map = new HashMap();
        int ans = recursive(s,0);

        return ans;

    }

    public int recursive(String s,int index){

        if(map.containsKey(index)){
            return map.get(index);
        }

        if(index>=s.length()-1){
            return 1;
        }

        if(index<s.length() && s.charAt(index)=='0'){
            return 0;
        }

        int ans = recursive(s,index+1);

        if(index<s.length()-1 && Integer.parseInt(s.substring(index,index+2))<=26){
            ans += recursive(s,index+2);
        }

        map.put(index,ans);

        return ans;
    }

    /**
     * I used a dp array of size n + 1 to save subproblem solutions. dp[0] means an empty string will have one way to decode, dp[1] means the way to decode a string of size 1. I then check one digit and two digit combination and save the results along the way. In the end, dp[n] will be the end result.
     * @param s
     * @return
     */
    public int numDecodingsDP(String s) {
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
            if (first >= 1 && first <= 9) {
                dp[i] += dp[i-1];
            }
            if (second >= 10 && second <= 26) {
                dp[i] += dp[i-2];
            }
        }
        return dp[n];
    }
}
