package code.linkedin;

import java.util.Arrays;

// O(n^2)
public class TraingleNumber {

    public int triangleNumber(int[] nums) {

        int count = 0;
        Arrays.sort(nums);

        for(int i=0;i<nums.length-2;i++){

            int j = i+1;
            int k = i+2;

            for(;j<nums.length-1;j++){
                while(k<nums.length && nums[i]+nums[j]>nums[k]){
                    k++;
                }

                count+=k-j-1;
            }
        }

        return count;
    }
}
