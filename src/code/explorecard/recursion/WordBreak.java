package code.explorecard.recursion;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

//https://leetcode.com/problems/word-break/submissions/
//https://www.youtube.com/watch?v=LmHWIsBQBU4
public class WordBreak {

    public boolean wordBreak(String s, List<String> wordDict) {
        if(s==null || s.length()==0){
            return true;
        }

        Set<String> set = new HashSet();

        for(String str:wordDict){
            set.add(str);
        }

        for(int i=0;i<s.length();i++){

            if(set.contains(s.substring(0,i+1)) && wordBreak(s.substring(i+1),wordDict)){

                return true;
            }
        }

        return false;
    }
}
