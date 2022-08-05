package code.bloomberg;

import java.util.*;

//https://leetcode.com/problems/word-break-ii/submissions/
//https://www.youtube.com/watch?v=necF6yyegiE
public class WordBreakII {

    public List<String> wordBreak(String s, List<String> wordDict) {
        Map<Integer,List<String>> map = new HashMap();
        Set<String> dict = new HashSet(wordDict);
        return helper(s,dict,0,map);
    }

    public List<String> helper(String s,Set<String> dict,int start,Map<Integer,List<String>> map){

        if(map.containsKey(start)){
            return map.get(start);
        }

        List<String> validSubstr = new ArrayList();

        if(start==s.length()){
            validSubstr.add("");
        }


        for(int end=start+1;end<=s.length();end++){
            String prefix = s.substring(start,end);

            if(dict.contains(prefix)){
                List<String> suffixes = helper(s,dict,end,map);

                for(String suffix:suffixes){
                    validSubstr.add(prefix+(suffix.isEmpty()?"":" "+suffix));
                }
            }
        }

        map.put(start,validSubstr);

        return validSubstr;
    }
}
