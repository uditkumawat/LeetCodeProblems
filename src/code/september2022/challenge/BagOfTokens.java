package code.september2022.challenge;

import java.util.Arrays;

//https://leetcode.com/problems/bag-of-tokens/submissions/
///TC - O(nlogn)
public class BagOfTokens {

    public int bagOfTokensScore(int[] tokens, int power) {

        Arrays.sort(tokens);
        int left = 0;
        int right = tokens.length-1;
        int score = 0;

        while(left<=right){
            if(power>=tokens[left]){
                score++;
                power = power - tokens[left];
                left++;
            }
            else if(score>=1 && left<right){  // atleast two elements are still present
                score--;
                power = power + tokens[right];
                right--;
            }
            else{
                break;
            }
        }

        return score;
    }
}
