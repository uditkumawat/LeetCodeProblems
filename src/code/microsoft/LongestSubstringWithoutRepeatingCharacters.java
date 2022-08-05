package code.microsoft;

import java.util.HashMap;
import java.util.Map;

//https://leetcode.com/problems/longest-substring-without-repeating-characters/submissions/
//TC - O(N)
//SC - O(N)
public class LongestSubstringWithoutRepeatingCharacters {

    public int lengthOfLongestSubstring(String s) {

        if(s==null || s.length()==0){
            return 0;
        }

        int maxLen = 0;
        int left = 0;
        int right = 0;
        int len = s.length();

        Map<Character,Integer> freqMap = new HashMap<>();

        while(right<len){
            if(freqMap.containsKey(s.charAt(right))){
                left = Math.max(freqMap.get(s.charAt(right)),left);
            }
            maxLen = Math.max(maxLen,right-left+1);
            freqMap.put(s.charAt(right),right+1);
            right++;
        }

        return maxLen;
    }
}
