package code.salesforce;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

//https://leetcode.com/problems/word-break/submissions/
//TC - O(n^2)
//SC - O(N)
public class WordBreak {

    public boolean wordBreak(String s, List<String> wordDict) {

        int n = s.length();

        Set<String> dict = new HashSet();

        for(String word:wordDict){
            dict.add(word);
        }

        return wb(s,dict);
    }

    public boolean wb(String s,Set<String> dict){

        boolean dp[] = new boolean[s.length()+1];
        dp[0] = true;

        for(int i=1;i<=s.length();i++){
            for(int j=0;j<i;j++){
                if(dp[j] && dict.contains(s.substring(j,i))){
                    dp[i] = true;
                    break;
                }
            }
        }

        return dp[s.length()];
    }
}
