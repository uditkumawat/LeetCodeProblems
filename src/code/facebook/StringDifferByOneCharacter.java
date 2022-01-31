package code.facebook;

import java.util.HashSet;
import java.util.Set;

public class StringDifferByOneCharacter {

    public static void main(String args[]){

        String dict[] = {"abcd","acbd","aacd"};

        StringDifferByOneCharacter obj = new StringDifferByOneCharacter();

        System.out.println(obj.differByOne(dict));

    }
    public boolean differByOne(String[] dict) {

        Set<String> set = new HashSet<>();

        for(int i=0;i<dict.length;i++){
            char word[] = dict[i].toCharArray();

            for(int j=0;j<word.length;j++){

                char temp = word[j];
                word[j] = '*';
                String newWord = new String(word);
                if(set.contains(newWord)){
                    return true;
                }
                set.add(newWord);
                word[j] = temp;
            }

        }

        return false;
    }
}
