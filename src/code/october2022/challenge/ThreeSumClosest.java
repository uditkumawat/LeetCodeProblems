package code.october2022.challenge;

import java.util.Arrays;

//https://leetcode.com/problems/3sum-closest/submissions/817715945/
//TC - O(n^2)
//https://www.youtube.com/watch?v=BS7_bRsJFiI
public class ThreeSumClosest {

    public int threeSumClosest(int[] nums, int target) {

        if(nums==null || nums.length==0){
            return 0;
        }

        Arrays.sort(nums);
        int n = nums.length;
        int sumClosest = Integer.MAX_VALUE;

        for(int i=0;i<n-1;i++){

            int left = i+1;
            int right = n-1;

            while(left<right){

                int sum = nums[i] + nums[left] + nums[right];

                if(sum>target){
                    right--;
                }
                else{
                    left++;
                }

                if(Math.abs(sumClosest-target)>Math.abs(sum-target)){
                    sumClosest = sum;
                }
            }
        }

        return sumClosest;
    }
}
