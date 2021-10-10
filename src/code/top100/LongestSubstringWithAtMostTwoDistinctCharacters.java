package code.top100;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 * Time complexity : \mathcal{O}(N)O(N) where N is a number of characters in the input string.
 *
 * Space complexity : \mathcal{O}(1)O(1) since additional space is used only for a hashmap with at most 3 elements.
 */
public class LongestSubstringWithAtMostTwoDistinctCharacters {

    public int getLength(String str){

        int left = 0;
        int right = 0;
        int maxLen  = 0;

        Map<Character,Integer> map = new HashMap<>();

        while(right<str.length()){
            map.put(str.charAt(right),right);
            if(map.size()>2){
                int smallestIndex = Collections.min(map.values());
                map.remove(str.charAt(smallestIndex));
                left = smallestIndex+1;
            }
            maxLen = Math.max(maxLen,right-left+1);
            right++;
        }

        return maxLen;
    }
}
