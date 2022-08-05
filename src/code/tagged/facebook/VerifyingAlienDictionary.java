package code.tagged.facebook;

import java.util.HashMap;
import java.util.Map;

//https://leetcode.com/problems/verifying-an-alien-dictionary/

/**
 * Time complexity : O(M)O(M).
 *
 * Storing the letter-order relation of each letter takes O(N)O(N) time. For the nested for-loops, we examine each pair of words in the outer-loop and for the inner loop, we check each letter in the current word. Therefore, we will iterate over all of letters in words.
 *
 * Taking both into consideration, the time complexity is O(M + N)O(M+N). However, we know that NN is fixed as 2626. Therefore, the time complexity is O(M)O(M).
 *
 * Space complexity : O(1)O(1). The only extra data structure we use is the hashmap/array that serves to store the letter-order relations for each word in order. Because the length of order is fixed as 2626, this approach achieves constant space complexity.
 */
public class VerifyingAlienDictionary {

    public static void main(String args[]){

        VerifyingAlienDictionary obj = new VerifyingAlienDictionary();

        String words[] = {"word","world","row"};
        String order = "worldabcefghijkmnpqstuvxyz";

        System.out.println(obj.isAlienSorted(words,order));
    }
    public boolean isAlienSorted(String[] words, String order) {

        Map<Character,Integer> orderMap = new HashMap();

        for(int i=0;i<order.length();i++){
            char c = order.charAt(i);
            orderMap.put(c,i);
        }

        for(int i=0;i<words.length-1;i++){
            String firstWord = words[i];
            String secondWord = words[i+1];

            int j=0;
            int k=0;

            while(j<firstWord.length() && k<secondWord.length()){

                char fc = firstWord.charAt(j);
                char sc = secondWord.charAt(k);

                if(fc!=sc){

                    if(orderMap.get(fc)>orderMap.get(sc)){
                        return false;
                    }
                }

                j++;
                k++;
            }

            if(j>=secondWord.length()){
                return false;
            }
        }

        return true;
    }
}
