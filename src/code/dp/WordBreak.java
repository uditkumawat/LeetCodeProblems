package code.dp;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

//https://leetcode.com/problems/word-break/
public class WordBreak {

    public boolean wordBreak(String s, List<String> wordDict) {

        Set<String> set = new HashSet();

        for(String str:wordDict){
            set.add(str);
        }
        return isWordBreaking(0,s,set,new Boolean[s.length()]);
    }

    public boolean isWordBreaking(int start,String s,Set<String> set,Boolean memo[]){

        if(s==null || s.length()==0 || start==s.length()){
            return true;
        }

        if(memo[start]!=null){
            return memo[start];
        }

        for(int end=start+1;end<=s.length();end++){

            if(set.contains(s.substring(start,end)) && isWordBreaking(end,s,set,memo)){
                return memo[start]=true;
            }
        }
        return memo[start]=false;
    }
}
