package code.march.challenge;

import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode.com/problems/strobogrammatic-number/
 * Time complexity : O(N)O(N).
 *
 * For each of the NN digits in the string, we're doing a single lookup and comparison.
 *
 * Space complexity : O(1)O(1).
 *
 * We are only using constant extra space. This is an in-place algorithm.
 */
public class StrobogrammaticNumberI {

    public static void main(String args[]){

        String num = "68199866189";

        StrobogrammaticNumberI obj = new StrobogrammaticNumberI();

        System.out.println(obj.isStrobogrammatic(num));
    }
    public boolean isStrobogrammatic(String num) {

        if(num==null || num.length()==0){
            return true;
        }

        Map<Character,Character> map = new HashMap<>();

        map.put('0','0');
        map.put('1','1');
        map.put('6','9');
        map.put('8','8');
        map.put('9','6');

        int left = 0;
        int right = num.length()-1;

        while(left<=right){
            char c1 = num.charAt(left);
            char c2 = num.charAt(right);

            if(!map.containsKey(c1) || !map.containsKey(c2) || map.get(c1)!=c2){
                return false;
            }

            left++;
            right--;
        }
        return true;
    }
}
