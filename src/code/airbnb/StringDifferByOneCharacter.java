package code.airbnb;

import java.util.HashSet;
import java.util.Set;

/**
 * Given a list of strings dict where all the strings are of the same length.
 *
 * Return true if there are 2 strings that only differ by 1 character in the same index, otherwise return false.
 */
public class StringDifferByOneCharacter {

    public static void main(String args[]){

        String dict[] = {"abcd","acbd","aacd"};

        StringDifferByOneCharacter obj = new StringDifferByOneCharacter();

        System.out.println(obj.differByOne(dict));

    }
    public boolean differByOne(String[] dict) {

        Set<String> hashSet = new HashSet<>();

        for(String str:dict){
           // System.out.println(str+" ");
            int len = str.length();
            for(int i=0;i<len;i++){
                String newStr = str.substring(0,i)+"*"+str.substring(i+1);
               // System.out.println(newStr);
                if(hashSet.contains(newStr)){
                    return true;
                }
                hashSet.add(newStr);
            }
        }
        return false;
    }
}
