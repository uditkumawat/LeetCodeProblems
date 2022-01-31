package code.facebook;

import java.util.HashMap;
import java.util.Map;

/**
 * https://www.youtube.com/watch?v=hEhf_oz3wsM
 */
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

       for(int i=0;i<s.length();i++){
           if(i>0 && map.get(s.charAt(i))>map.get(s.charAt(i-1))){
               res+=map.get(s.charAt(i))-2*map.get(s.charAt(i-1));
           }
           else{
               res+=map.get(s.charAt(i));
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
