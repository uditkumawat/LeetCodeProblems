package code.feb.challenge;

import java.util.Arrays;

public class FindTheDifference {

    public static void main(String args[]){

        String s = "eeee";
        String t = "eeeee";

        FindTheDifference obj = new FindTheDifference();

        System.out.println(obj.findTheDifferenceXOR(s,t));

    }

    // O(nlogn)
    public char findTheDifference(String s, String t) {

        char sortedS[] = s.toCharArray();
        char sortedT[] = t.toCharArray();

        Arrays.sort(sortedS);
        Arrays.sort(sortedT);

        int i=0;
        while(i<s.length()){
            if(sortedS[i]!=sortedT[i]){
                return sortedT[i];
            }
            i++;
        }

        return sortedT[i];
    }

    //O(logn)
    public char findTheDifferenceXOR(String s, String t) {

        // Initialize ch with 0, because 0 ^ X = X
        // 0 when XORed with any bit would not change the bits value.
        char ch = 0;

        // XOR all the characters of both s and t.
        for (int i = 0; i < s.length(); i += 1) {
            ch ^= s.charAt(i);
        }
        for (int i = 0; i < t.length(); i += 1) {
            ch ^= t.charAt(i);
        }

        // What is left after XORing everything is the difference.
        return ch;
    }
}
