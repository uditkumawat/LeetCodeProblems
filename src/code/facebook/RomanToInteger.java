package code.facebook;

import java.util.HashMap;
import java.util.Map;

public class RomanToInteger {

    public static void main(String args[]){

        RomanToInteger obj = new RomanToInteger();

        System.out.println(obj.romanToInt("III"));
        System.out.println(obj.romanToInt("IV"));
        System.out.println(obj.romanToInt("IX"));
        System.out.println(obj.romanToInt("LVIII"));
        System.out.println(obj.romanToInt("MCMXCIV"));
    }

    public int romanToInt(String s) {

        if(s==null || s.length()==0){
            return 0;
        }

        return getIntFromRoman(s);
    }

    public int getIntFromRoman(String s){
        Map<Character,Integer> map = getMappings();

        int res = 0;

        //moving from backwards
        for(int i=s.length()-1;i>=0;i--){

            char current = s.charAt(i);

            if(i==s.length()-1){
                res = res+ map.get(current);
            }
            else{
                char prev = s.charAt(i+1);
                int valueOfCurrent = map.get(current);
                int valueOfPrev = map.get(prev);
                if(valueOfCurrent<valueOfPrev){
                    res = res - valueOfCurrent;
                }
                else{
                    res = res + valueOfCurrent;
                }
            }
        }
        return res;
    }

    public Map<Character,Integer> getMappings(){
        Map<Character,Integer> map = new HashMap<>();
        map.put('I',1);
        map.put('V',5);
        map.put('X',10);
        map.put('L',50);
        map.put('C',100);
        map.put('D',500);
        map.put('M',1000);
        return map;
    }
}
