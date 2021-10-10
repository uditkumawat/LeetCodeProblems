package code.microsoft;

import code.google.SumOfOddLengthSubArray;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Given a string array words, return an array of all characters that show up in all strings within the words (including duplicates). You may return the answer in any order.
 */
public class FindCommonCharacters {

    public static void main(String args[]){

        FindCommonCharacters obj = new  FindCommonCharacters();
        String words[] = {"bella","label","roller"};
        List<String> res = obj.commonChars(words);

    }

    public List<String> commonChars(String A[]){

        List<String> ans = new ArrayList<>();
        int count[] = new int[26];
        Arrays.fill(count,Integer.MAX_VALUE);

        for(String str:A){
            int cnt[] = new int[26];
            for(char c:str.toCharArray()){
                cnt[c-'a']++;
            }
            for(int i=0;i<26;i++){
                count[i] = Math.min(count[i],cnt[i]);
            }
        }

        for(char c='a';c<='z';c++){
            while(count[c-'a']-->0){
                ans.add(""+c);
            }
        }

        return ans;
    }
}
