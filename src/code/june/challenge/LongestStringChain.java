package code.june.challenge;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

//https://www.youtube.com/watch?v=HX3xggriPTo
//
public class LongestStringChain {

    public int longestStrChain(String[] words) {

        Arrays.sort(words,(word1, word2)->word1.length()-word2.length());

        Map<String,Integer> dp = new HashMap<>();


        int res = 0;

        for(String word:words){

            int longestStringChain = 0;

            for(int i=0;i<word.length();i++){

                String predecessor = word.substring(0,i)+word.substring(i+1);

                longestStringChain = Math.max(longestStringChain,dp.getOrDefault(predecessor,0)+1);
            }

            dp.put(word,longestStringChain);

            res = Math.max(res,longestStringChain);
        }

        return res;
    }
}
