package code.bloomberg;

import java.util.Arrays;

//TC - O(n^2)
public class ValidTriangleNumber {

    public int triangleNumber(int[] nums) {

        int count = 0;

        Arrays.sort(nums);

        for(int i=0;i<nums.length;i++){
            int k = i+2;
            for(int j=i+1;j<nums.length-1 && nums[i]!=0;j++){

                while(k<nums.length && nums[i]+nums[j]>nums[k]){
                    k++;
                }

                count = count + k-j-1;
            }
        }

        return count;
    }
}
