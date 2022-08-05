package code.june.challenge;

import java.util.Arrays;

//https://leetcode.com/problems/minimum-swaps-to-group-all-1s-together/solution/
//TC - O(N)
public class MinimumSwapsToGroupAll1sTogether {

    public int minSwaps(int[] data) {

        int ones = Arrays.stream(data).sum();

        int cnt_ones = 0;
        int max_one = 0;
        int left = 0;
        int right = 0;

        while(right<data.length){

            cnt_ones = cnt_ones + data[right++];

            if(right-left>ones){
                cnt_ones = cnt_ones - data[left++];
            }

            max_one = Math.max(max_one,cnt_ones);
        }

        return ones-max_one;
    }
}
