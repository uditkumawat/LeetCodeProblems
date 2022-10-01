package code.leetcodeTopInterviewQuestions;

import java.util.HashMap;
import java.util.Map;

//https://leetcode.com/problems/longest-substring-without-repeating-characters/solution/
//TC - O(n) - length of string
//SC - O(m+1) - m is the substring without repeating character
public class LongestSubstringWithoutRepeatingCharacters {

    public int lengthOfLongestSubstring(String s) {
        int n = s.length(), ans = 0;
        Map<Character, Integer> map = new HashMap<>(); // current index of character
        // try to extend the range [i, j]
        for (int j = 0, i = 0; j < n; j++) {
            if (map.containsKey(s.charAt(j))) {
                i = Math.max(map.get(s.charAt(j)), i);   //max is taken because of this test case - "abcdeafbdgcbb"
            }
            ans = Math.max(ans, j - i + 1);
            map.put(s.charAt(j), j + 1);
        }
        return ans;
    }
}
