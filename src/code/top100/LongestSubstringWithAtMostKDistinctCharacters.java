package code.top100;

import java.util.HashMap;
import java.util.Map;

//TC - O(N)
//SC - O(K) hashmap for k+1 distinct characters
public class LongestSubstringWithAtMostKDistinctCharacters {

    public static void main(String args[]){
        String s = "loveleetcode";
        int k = 4;

        System.out.println(lengthOfLongestSubstringKDistinct(s,k));
    }
    public static int lengthOfLongestSubstringKDistinct(String s, int k) {

        int left = 0;
        int maxLength = 0;

        Map<Character,Integer> map = new HashMap<>();

        for(int right=0;right<s.length();right++){

            char c = s.charAt(right);
            map.put(c, map.getOrDefault(c,0)+1);

            while(map.size()>k){
                char leftChar = s.charAt(left);
                map.put(leftChar,map.get(leftChar)-1);

                if(map.get(leftChar)==0){
                    map.remove(leftChar);
                }

                left++;
            }

            maxLength = Math.max(maxLength,right-left+1);
        }

        return maxLength;
    }
}
