package code.facebook;

import java.util.HashMap;
import java.util.Map;

/**
 * Given a string s, find the length of the longest substring without repeating characters.
 */
public class LongestSubStringWithoutRepeatingCharacters {

    public static void main(String args[]){
        LongestSubStringWithoutRepeatingCharacters obj = new LongestSubStringWithoutRepeatingCharacters();

        String str = "bbbb";

        System.out.println(obj.lengthOfLongestSubstring(str));
    }

    public int lengthOfLongestSubstring(String s) {

        if(s==null || s.length()==0){
            return 0;
        }

        int maxLength = 0;

        maxLength = getLongestSubStringWithoutRepeatingCharacters(s);

        return maxLength;
    }

    public int getLongestSubStringWithoutRepeatingCharacters(String s){

        int len = s.length();

        Map<Character,Integer> map = new HashMap<>();

        int left=0;
        int res=0;

        for(int right=0;right<len;right++){
            if(map.containsKey(s.charAt(right))){
                left = Math.max(map.get(s.charAt(right)),left);
            }
            res = Math.max(res,right-left+1);
            map.put(s.charAt(right),right+1);
        }

        return res;
    }
}
