package code.july.challenge;

import java.util.ArrayList;
import java.util.List;

//https://leetcode.com/problems/word-subsets/submissions/
//https://www.youtube.com/watch?v=8OI8TsGj14g
public class WordSubsets {

    public List<String> wordSubsets(String[] words1, String[] words2) {

        List<String> res = new ArrayList();

        int maxFreqMap[] = new int[26];

        for(String word:words2){
            int freq[] = getFreqMap(word);
            for(int i=0;i<26;i++){
                maxFreqMap[i] = Math.max(maxFreqMap[i],freq[i]);
            }
        }

        for(String word:words1){
            int freqMap[] = getFreqMap(word);
            boolean notFound = false;
            for(int i=0;i<26;i++){
                if(freqMap[i]<maxFreqMap[i]){
                    notFound = true;
                    break;
                }
            }

            if(!notFound){
                res.add(word);
            }
        }
        return res;

    }

    public int[] getFreqMap(String word){
        int count[] = new int[26];
        for(char c:word.toCharArray()){
            count[c-'a']++;
        }
        return count;
    }
}
