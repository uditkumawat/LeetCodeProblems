package code.march.challenge;

import java.util.Arrays;

//TC - O(N)
//SC - O(N)
//https://leetcode.com/problems/arithmetic-slices/
//https://www.youtube.com/watch?v=rSi4MpGEz1M
//https://www.youtube.com/watch?v=FCNips6IPoM
public class ArtihmeticSlices {

    public static void main(String args[]){

        int nums[] = {1,2,3,4};

        ArtihmeticSlices obj = new ArtihmeticSlices();

        System.out.println(obj.countNumberOfArithmeticSlices(nums));

    }
    public int numberOfArithmeticSlices(int[] nums) {

        int totalCount = 0;

        if(nums==null || nums.length<3){
            return 0;
        }

        int dp[] = new int[nums.length];

        Arrays.fill(dp,0);

        for(int i=2;i<nums.length;i++){
            if(nums[i]-nums[i-1]==nums[i-1]-nums[i-2]){
                dp[i] = dp[i-1]+1;
            }
            totalCount+=dp[i];
        }

        return totalCount;
    }

    //SC - O(1)
    public int countNumberOfArithmeticSlices(int[] nums) {
        int previousCount = 0;
        int totalCount = 0;
        if(nums==null || nums.length<3){
            return 0;
        }

        for(int i=2;i<nums.length;i++){
            if(nums[i]-nums[i-1]==nums[i-1]-nums[i-2]){
                previousCount = previousCount+1;
            }
            else{
                previousCount = 0;
            }
            totalCount = totalCount+previousCount;
        }

        return totalCount;
    }
}
