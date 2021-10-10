package code.top100;

import java.util.List;

public class MajorityElement {

    public static void main(String args[]){
        int arr[] = {3,3,4,3,4};
        System.out.println(majorityElement(arr));

    }

    public static int majorityElement(int[] nums) {

        if(nums==null || nums.length==0){
            return -1;
        }

        int candidate = nums[0];
        int count = 0;
        for(int element:nums){
            if(count==0){
                candidate = element;
            }
            if(element==candidate){
                count++;
            }
            else{
                count--;
            }
        }

        return candidate;
    }
}
