package code.top100;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

//TC - O(n)
//SC - O(n)
public class LongestSubstringWithoutRepeating {

    public int lengthOfLongestSubstring(String s) {
        int n = s.length();
        int ans = 0;
        Map<Character,Integer> map = new HashMap<>();
        int i=0;
        for(int j=0;j<n;j++){
            if(map.containsKey(s.charAt(j))){
                i = Math.max(map.get(s.charAt(j)),i);
            }
            ans = Math.max(ans,j-i+1);
            map.put(s.charAt(j),j+1);
        }

        return ans;
    }
}
