package code.bloomberg;

import java.util.HashMap;
import java.util.Map;

//TC - O(N) len of string
//SC - O(1)
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

        int res = 0;

        for(int i=s.length()-1;i>=0;i--){
            char c = s.charAt(i);
            res = res + map.get(c);
            if(i<s.length()-1){
                int curr = map.get(c);
                int prev = map.get(s.charAt(i+1));
                if(prev>curr){
                    res = res - 2*curr;
                }
            }
        }

        return res;
    }
}
