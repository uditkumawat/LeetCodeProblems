package code.booking.com;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

//https://leetcode.com/problems/most-common-word/
public class MostCommonWord {

    public static void main(String args[]){

        String para = "Bob hit a ball, the hit BALL flew far after it was hit.";
        String banned[] = {"hit"};

        MostCommonWord obj = new MostCommonWord();
        String res = obj.mostCommonWord(para,banned);

        System.out.println(res);
    }
    public String mostCommonWord(String paragraph, String[] banned) {

        //remove punctuations
        String str = paragraph.replaceAll("[^a-zA-Z0-9 ]"," ").toLowerCase();

        //split based on space
        String words[] = str.split("\\s+");

        Set<String> bannedWords = new HashSet<>();

        for(String word:banned){
            bannedWords.add(word);
        }

        Map<String,Integer> map = new HashMap();
        for(String word:words){
            if(!bannedWords.contains(word)){
                map.put(word,map.getOrDefault(word,0)+1);
            }
        }

        int max = 0;
        String res = null;

        for(Map.Entry<String,Integer> entry:map.entrySet()){
            if(entry.getValue()>max){
                max = entry.getValue();
                res = entry.getKey();
            }
        }

        return res;
    }
}
