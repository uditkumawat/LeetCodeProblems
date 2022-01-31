package code.facebook;

import java.util.HashMap;
import java.util.Map;

/**
 * Let NN be the length of order, and MM be the total number of characters in words.
 *
 * Time complexity : O(M)O(M).
 *
 * Storing the letter-order relation of each letter takes O(N)O(N) time. For the nested for-loops, we examine each pair of words in the outer-loop and for the inner loop, we check each letter in the current word. Therefore, we will iterate over all of letters in words.
 *
 * Taking both into consideration, the time complexity is O(M + N)O(M+N). However, we know that NN is fixed as 2626. Therefore, the time complexity is O(M)O(M).
 *
 * Space complexity : O(1)O(1). The only extra data structure we use is the hashmap/array that serves to store the letter-order relations for each word in order. Because the length of order is fixed as 2626, this approach achieves constant space complexity.
 */
public class AlienDictionary {

    public static void main(String args[]){
        String words[] = {"hello","leetcode"};
        String order = "hlabcdefgijkmnopqrstuvwxyz";

        AlienDictionary obj = new AlienDictionary();

        System.out.println(obj.isAlienSorted(words,order));

    }
    public boolean isAlienSorted(String[] words, String order) {

        Map<Character,Integer> map = new HashMap<>();

        for(int i=0;i<order.length();i++){
            map.put(order.charAt(i),i);
        }

        for(int i=0;i<words.length-1;i++){
            String word1 = words[i];
            String word2 = words[i+1];
            if(word1.length()>word2.length()){
                return false;
            }

            for(int pos=0;pos<Math.min(word1.length(),word2.length());pos++){
                if(word1.charAt(pos)!=word2.charAt(pos)) {
                    if (map.get(word1.charAt(pos)) > map.get(word2.charAt(pos))) {
                        return false;
                    }
                    else{
                        break;
                    }
                }
            }
        }

        return true;
    }
}
