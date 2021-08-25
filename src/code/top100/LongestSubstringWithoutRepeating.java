package code.top100;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

//TC - O(n)
//SC - O(n)
public class LongestSubstringWithoutRepeating {

    public int lengthOfLongestSubstring(String s) {
        int i = 0, j = 0, max = 0;
        Set<Character> set = new HashSet<>();

        while (j < s.length()) {
            if (!set.contains(s.charAt(j))) {
                set.add(s.charAt(j++));
                max = Math.max(max, set.size());
            } else {
                set.remove(s.charAt(i++));
            }
        }

        return max;
    }
}
