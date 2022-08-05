package code.leetcode.studyplan;

import java.util.HashMap;
import java.util.Map;

//https://leetcode.com/problems/first-unique-character-in-a-string/submissions/
//TC - O(N)
//SC - O(UniqueCharactersCount)
public class FirstUniqueCharacterInString {

    public int firstUniqChar(String s) {

        Map<Character,Integer> map = new HashMap<>();

        int index = -1;

        for(int i=0;i<s.length();i++){

            char c = s.charAt(i);
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
