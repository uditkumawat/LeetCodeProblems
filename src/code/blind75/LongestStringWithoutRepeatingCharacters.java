package code.blind75;

import java.util.HashMap;
import java.util.Map;

//https://leetcode.com/problems/longest-substring-without-repeating-characters/
//TC - O(N)
//SC  - O(N)
public class LongestStringWithoutRepeatingCharacters {

    public int lengthOfLongestSubstring(String s) {

        if(s==null || s.length()==0){
            return 0;
        }

        Map<Character,Integer> map = new HashMap();

        int right = 0;
        int left = 0;
        int maxLength = 0;

        while(right<s.length()){
            char c = s.charAt(right);

            if(map.containsKey(c)){
                left = Math.max(left,map.get(c)+1);
            }
            map.put(c,right);
            maxLength = Math.max(maxLength,right-left+1);
            right++;
        }

        return maxLength;
    }
}
