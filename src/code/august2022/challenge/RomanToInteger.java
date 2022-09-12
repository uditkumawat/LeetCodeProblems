package code.august2022.challenge;

import java.util.HashMap;
import java.util.Map;

//https://leetcode.com/problems/roman-to-integer/submissions/
//Tc - O(N)
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
