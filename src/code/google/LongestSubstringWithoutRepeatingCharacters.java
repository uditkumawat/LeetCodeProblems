package code.google;

import java.util.HashMap;
import java.util.Map;

public class LongestSubstringWithoutRepeatingCharacters {

    public static void main(String args[]){

        String s = "abcdeafbdgcbb";

        LongestSubstringWithoutRepeatingCharacters obj = new LongestSubstringWithoutRepeatingCharacters();

        System.out.println(obj.lengthOfLongestSubstring(s));

    }
    public int lengthOfLongestSubstring(String s) {

        if(s==null || s.length()==0){
            return 0;
        }

        Map<Character,Integer> map = new HashMap<>();
        int left = 0;
        int maxLen = 0;

        for(int right=0;right<s.length();right++){
            if(map.containsKey(s.charAt(right))){
                left = Math.max(map.get(s.charAt(right))+1,left);
            }
            map.put(s.charAt(right),right);
            maxLen = Math.max(maxLen,right-left+1);
        }

        return maxLen;
    }
}
