package code.microsoft;

import code.google.HeightChecker;

import java.util.HashMap;
import java.util.Map;

/**
 * You are given an array of strings words and a string chars.
 *
 * A string is good if it can be formed by characters from chars (each character can only be used once).
 *
 * Return the sum of lengths of all good strings in words.
 */
public class FindWordsThatCanBeFormedByCharacters {

    public static void main(String args[]){

        FindWordsThatCanBeFormedByCharacters obj = new FindWordsThatCanBeFormedByCharacters();
        String words[] = {"cat","bt","hat","tree"};
        String chars = "atach";

        System.out.println(obj.countCharacters(words,chars));
    }

    public int countCharacters(String[] words, String chars) {

        HashMap<Character,Integer> map = new HashMap<>();

        for(char c:chars.toCharArray()){
            map.put(c,map.getOrDefault(c,0)+1);
        }

        int res = 0;

        HashMap<Character,Integer> count;
        for(String word:words){
            count = (HashMap<Character, Integer>)map.clone();
            boolean isPossible = true;

            for(char c:word.toCharArray()){

                if(!count.containsKey(c) || count.containsKey(c) && count.get(c)<=0){
                    isPossible = false;
                    break;
                }
                else{
                    System.out.println(c);
                    System.out.println(count);

                    count.put(c,count.get(c)-1);
                }
            }

            if(isPossible){
                res+=word.length();
            }
        }

        return res;
    }
}
