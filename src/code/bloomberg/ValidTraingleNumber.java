package code.bloomberg;

import java.util.Arrays;

//https://www.youtube.com/watch?v=pmsex9gj1PI
public class ValidTraingleNumber {

    public int triangleNumber(int[] nums) {

        if(nums==null || nums.length==0){
            return 0;
        }

        Arrays.sort(nums);

        int left = 0;
        int right = 0;
        int count = 0;

        for(int i=2;i<nums.length;i++){
            left = 0;
            right = i-1;

            while(left<right){
                if(nums[left]+nums[right]>nums[i]){
                    count+=right-left;
                    right--;
                }
                else{
                    left++;
                }
            }
        }

        return count;
    }
}
