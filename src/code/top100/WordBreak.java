package code.top100;

import java.util.HashSet;
import java.util.Set;

//TC - O(n^3)
//https://leetcode.com/problems/word-break/discuss/43796/Accepted-Java-Solution
public class WordBreak {

    public static void main(String args[]){

        Set<String> dict = new HashSet<>();
        dict.add("a");
        dict.add("bc");
        dict.add("d");

        System.out.println(wordBreak("abcd",dict));
    }

    public static boolean wordBreak(String s, Set<String> dict){

        boolean dp[] = new boolean[s.length()+1];
        //null string always present in array
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
