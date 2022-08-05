package code.leetcode.studyplan75;

import java.util.HashMap;
import java.util.Map;

//https://leetcode.com/problems/isomorphic-strings/submissions/
//TC - O(N)
//SC - O(N)
//https://www.youtube.com/watch?v=GixTBEkxudg
public class IsomorphicStrings {

    public boolean isIsomorphic(String s, String t) {

        if(s.length()!=t.length()){
            return false;
        }

        Map<Character,Character> sTmap = new HashMap<>();

        Map<Character,Character> tSmap = new HashMap<>();

        for(int i=0;i<s.length();i++){

            char sChar = s.charAt(i);
            char tChar = t.charAt(i);

            if(sTmap.containsKey(sChar)){
                char temp = sTmap.get(sChar);
                if(temp!=tChar){
                    return false;
                }
            }
            if(tSmap.containsKey(tChar)){
                char temp = tSmap.get(tChar);
                if(temp!=sChar){
                    return false;
                }
            }

            sTmap.put(sChar,tChar);
            tSmap.put(tChar,sChar);

        }

        return true;

    }
}
