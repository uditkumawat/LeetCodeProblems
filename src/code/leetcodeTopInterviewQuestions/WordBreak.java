package code.leetcodeTopInterviewQuestions;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

//https://leetcode.com/problems/word-break/solution/
/**
 * Time complexity : O(n^3)
 *  ). There are two nested loops, and substring computation at each iteration. Overall that results in O(n^3)O(n
 * 3
 *  ) time complexity.
 *
 * Space complexity : O(n). Length of pp array is n+1n+1.
 */
public class WordBreak {

    public boolean wordBreak(String s, List<String> wordDict) {
        Set<String> wordDictSet = new HashSet<>(wordDict);
        boolean[] dp = new boolean[s.length() + 1];
        dp[0] = true;
        for (int i = 1; i <= s.length(); i++) {
            for (int j = 0; j < i; j++) {
                if (dp[j] && wordDictSet.contains(s.substring(j, i))) {
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[s.length()];
    }
}
