package code.facebook;

import java.util.HashMap;
import java.util.Map;

public class FirstUniqueCharInString {

    public static void main(String args[]){

        String str = "loveleetcode";

        FirstUniqueCharInString obj = new FirstUniqueCharInString();

        System.out.println(obj.firstUniqChar(str));

    }
    public int firstUniqChar(String s) {

        Map<Character,Integer> map = new HashMap<>();

        for(char c:s.toCharArray()){
            map.put(c,map.getOrDefault(c,0)+1);
        }

        for(int i=0;i<s.length();i++){
            if(map.get(s.charAt(i))==1){
                return i;
            }
        }

        return -1;
    }
}
