package code.july.challenge;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

//https://leetcode.com/problems/number-of-matching-subsequences/submissions/
public class NumberOfMatchingSubSequences {

    public int numMatchingSubseq(String s, String[] words) {

        Map<Character, Queue<String>> map = new HashMap();
        for(int i=0;i<s.length();i++){
            map.put(s.charAt(i),new LinkedList<String>());
        }

        for(String word:words){
            char firstChar = word.charAt(0);
            if(map.containsKey(firstChar)){
                map.get(firstChar).add(word);
            }
        }

        int res = 0;

        for(int i=0;i<s.length();i++){
            Queue<String> q = map.get(s.charAt(i));
            int size = q.size();
            for(int j=0;j<size;j++){
                String str = q.poll();
                if(str.substring(1).length()==0){
                    res++;
                }
                else{
                    if(map.containsKey(str.charAt(1))){
                        map.get(str.charAt(1)).add(str.substring(1));
                    }
                }
            }
        }

        return res;
    }
}
