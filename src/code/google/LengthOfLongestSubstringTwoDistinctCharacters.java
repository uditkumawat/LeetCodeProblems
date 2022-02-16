package code.google;

import java.util.HashMap;
import java.util.Map;

public class LengthOfLongestSubstringTwoDistinctCharacters {

    public static void main(String args[]){

        String s = "eceba";

        LengthOfLongestSubstringTwoDistinctCharacters obj = new LengthOfLongestSubstringTwoDistinctCharacters();

        System.out.println(obj.lengthOfLongestSubstringTwoDistinct(s));
    }
    public int lengthOfLongestSubstringTwoDistinct(String s) {

        if(s==null || s.length()==0){
            return 0;
        }

        Map<Character,Integer> map = new HashMap<>();

        int left = 0;
        int right = 0;
        int resLen = 0;

        while(right<s.length()){
            char c = s.charAt(right);

            map.put(c,map.getOrDefault(c,0)+1);


            while(map.size()>2){
                char oldChar = s.charAt(left);
                if(map.containsKey(oldChar)){
                    map.put(oldChar,map.get(oldChar)-1);
                    if(map.get(oldChar)<=0){
                        map.remove(oldChar);
                    }
                }
                left++;
            }

            if(map.size()==2){
                resLen = Math.max(resLen,right-left+1);
            }

            right++;
        }

        return resLen;
    }
}
