package code.leetcodeTopInterviewQuestions;

import java.util.HashMap;
import java.util.Map;

//https://leetcode.com/problems/roman-to-integer/solution/
//TC - O(1)
//SC - O(1)

/**
 * Time complexity : O(1)O(1).
 *
 * As there is a finite set of roman numerals, the maximum number possible number can be 3999, which in roman numerals is MMMCMXCIX. As such the time complexity is O(1)O(1).
 *
 * If roman numerals had an arbitrary number of symbols, then the time complexity would be proportional to the length of the input, i.e. O(n)O(n). This is assuming that looking up the value of each symbol is O(1)O(1).
 *
 * Space complexity : O(1)O(1).
 *
 * Because only a constant number of single-value variables are used, the space complexity is O(1)O(1).
 */
public class RomanToInteger {

    public int romanToInt(String s) {

        if(s==null || s.length()==0){
            return 0;
        }

        Map<Character,Integer> map = new HashMap();
        map.put('I',1);
        map.put('V',5);
        map.put('X',10);
        map.put('L',50);
        map.put('C',100);
        map.put('D',500);
        map.put('M',1000);

        int res = map.get(s.charAt(s.length()-1));

        for(int i=s.length()-2;i>=0;i--){
            char curr = s.charAt(i);
            char prev = s.charAt(i+1);

            if(map.get(curr)<map.get(prev)){
                res = res - map.get(curr);
            }
            else{
                res = res + map.get(curr);
            }
        }
        return res;
    }
}
