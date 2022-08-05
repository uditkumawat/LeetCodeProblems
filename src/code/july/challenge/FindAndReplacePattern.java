package code.july.challenge;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//https://leetcode.com/problems/find-and-replace-pattern/solution/

/**
 * Time Complexity: O(N * K)O(N∗K), where NN is the number of words, and KK is the length of each word.
 *
 * Space Complexity: O(N * K)O(N∗K), the space used by the answer.
 */
public class FindAndReplacePattern {

    public List<String> findAndReplacePattern(String[] words, String pattern) {

        String p = normalize(pattern);
        List<String> res = new ArrayList();
        for(String word:words){
            if(p.equals(normalize(word))){
                res.add(word);
            }
        }
        return res;
    }

    public String normalize(String word){

        StringBuilder sb = new StringBuilder();
        Map<Character,Integer> map = new HashMap();

        for(int i=0;i<word.length();i++){
            map.putIfAbsent(word.charAt(i),map.size());
            sb.append(map.get(word.charAt(i)));
        }

        return sb.toString();
    }
}
