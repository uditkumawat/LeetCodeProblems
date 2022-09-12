package code.august2022.challenge;

import java.util.HashSet;
import java.util.Set;

//TC - O(S) - sum of length of words in words array
//SC - (S)
public class UniqueMorseCodeWords {

    String str[] = {".-","-...","-.-.","-..",".","..-.","--.","....","..",".---","-.-",".-..","--","-.","---",".--.","--.-",".-.","...","-","..-","...-",".--","-..-","-.--","--.."};

    public int uniqueMorseRepresentations(String[] words) {

        if(words==null || words.length==0){
            return 0;
        }

        Set<String> set = new HashSet();

        for(String word:words){

            String s = getHash(word);

            set.add(s);
        }

        return set.size();
    }

    public String getHash(String s){

        StringBuilder sb = new StringBuilder();
        for(char c:s.toCharArray()){
            sb.append(str[c-'a']);
        }
        return sb.toString();
    }
}
