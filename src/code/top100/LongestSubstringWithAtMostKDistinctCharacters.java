package code.top100;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

//TC - O(N)
//SC - O(K) hashmap for k+1 distinct characters
//https://leetcode.com/problems/longest-substring-with-at-most-k-distinct-characters/solution/
public class LongestSubstringWithAtMostKDistinctCharacters {

    public static void main(String args[]){
        String s = "loveleetcode";
        int k = 4;

        System.out.println(lengthOfLongestSubstringKDistinct(s,k));
    }
    public static int lengthOfLongestSubstringKDistinct(String s, int k) {

        int n = s.length();
        if (n * k == 0) {
            return 0;
        }
        int left = 0;
        int right = 0;

        Map<Character, Integer> rightmostPosition = new HashMap<>();

        int maxLength = 1;

        while (right < n) {
            rightmostPosition.put(s.charAt(right), right++);

            if (rightmostPosition.size() == k + 1) {
                int lowestIndex = Collections.min(rightmostPosition.values());
                rightmostPosition.remove(s.charAt(lowestIndex));
                left = lowestIndex + 1;
            }

            maxLength = Math.max(maxLength, right - left);
        }
        return maxLength;
    }
}
